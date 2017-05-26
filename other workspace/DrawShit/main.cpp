#include <SDL2/SDL.h>
#include <iostream>
#include <algorithm>
#include <vector>
#include <iterator>
#include <fstream>
#include <sstream>
#include <map>

#include "Drawer.h"
#include "NoSuchFunctionError.h"
#include "CouldNotGetValuesError.h"
#include "NoSuchPointError.h"
#include "NoSuchVariableError.h"
#include "NotValidTurnError.h"

using namespace std;

vector<string> todo;
Drawer drawer;
string file;

void get_file_contents(string filename)
{
	todo.clear();
	ifstream ifstr(filename);

	if (!ifstr.is_open())
	{
		throw;
	}

	for (string line; getline(ifstr, line);)
	{
		if (!(line.size() > 2 && line.substr(0, 2) == "//"))
		{
			line.erase(remove_if(line.begin(), line.end(), ::isspace), line.end());
			if (line.size() > 0)
			{
				todo.push_back(line);
			}
		}
	}
	ifstr.close();
}

void print_intro_file()
{
	get_file_contents("intro.txt");
	drawer.draw(todo);

	bool file_gotten = false;
		while (!file_gotten)
		{
			SDL_Event e;
			while (SDL_PollEvent(&e))
			{
				if (e.type == SDL_KEYDOWN)
				{
					//cout << e.key.keysym.sym << endl;
					if (e.key.keysym.sym == SDLK_SPACE)
					{
						file_gotten = true;
					}
					else if (e.key.keysym.sym == SDLK_ESCAPE)
					{
						file = "";
					}
					else if (e.key.keysym.sym >= 45 && e.key.keysym.sym <= 322)
					{
						file += char(e.key.keysym.sym);
					}
				}
			}
		}
}

int main(int argc, char* argv[])
{
	drawer.init();
	print_intro_file();

	get_file_contents(file);

	drawer.set_color(0, 0, 0);
	drawer.clear_render();
	drawer.set_color(255, 255, 255);

	try
	{
		//drawer.draw(todo);
		drawer.draw_char("a");
	}
	catch (NoSuchFunctionError& e)
	{
		cout << "This is not a builtin function: '" << e.what() << '\'' << endl;
		return 1;
	}
	catch (CouldNotGetValuesError& e)
	{
		cout << "Could not get the values in this line: '" << e.what() << '\'' << endl;
		return 1;
	}
	catch (NoSuchPointError& e)
	{
		cout << "This point was not initiated: '" << e.what() << '\'' << endl;
		return 1;
	}
	catch (NoSuchVariableError& e)
	{
		cout << "This variable was not initiated: '" << e.what() << '\'' << endl;
		return 1;
	}
	catch (NotValidTurnError& e)
	{
		cout << "This is not a valid turn: '" << e.what() << '\'' << endl;
		return 1;
	}
	drawer.pause();
	drawer.end();

	return 0;
}
