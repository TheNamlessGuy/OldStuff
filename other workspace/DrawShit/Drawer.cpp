#include <vector>
#include <string>
#include <map>
#include <sstream>
#include <fstream>
#include <SDL2/SDL.h>
#include <algorithm>
#include <iostream>
#include <random>
#include <ctime>

#include "Drawer.h"
#include "NoSuchFunctionError.h"
#include "CouldNotGetValuesError.h"
#include "NoSuchPointError.h"
#include "NoSuchVariableError.h"
#include "NotValidTurnError.h"

using namespace std;

Drawer::Drawer(): direction(Drawer::EAST), delay(100), x(0), y(0), r(255), g(255), b(255),
		window(nullptr), renderer(nullptr), looping(false), looptimes(0)
{}

Drawer::~Drawer() {}

void Drawer::init()
{
	if (SDL_Init(SDL_INIT_VIDEO) != 0)
	{
			throw;
	}

	window = SDL_CreateWindow("Draw Stuff", SDL_WINDOWPOS_UNDEFINED, SDL_WINDOWPOS_UNDEFINED, SCR_W, SCR_H, SDL_WINDOW_RESIZABLE);
	renderer = SDL_CreateRenderer(window, -1, 0);

	SDL_SetHint(SDL_HINT_RENDER_SCALE_QUALITY, "linear");
	SDL_RenderSetLogicalSize(renderer, SCR_W, SCR_H);

	SDL_SetRenderDrawColor(renderer, 0, 0, 0, 255);
	SDL_RenderClear(renderer);
	SDL_RenderPresent(renderer);
}

void Drawer::end()
{
	SDL_DestroyWindow(window);
	SDL_DestroyRenderer(renderer);

	SDL_Quit();
}

void Drawer::draw(string s)
{
	iss.clear();
	to_lower(s);
	transform_vars(s);
	prompt(s);
	if (looping)
	{
		update_loop(s);
	}
	else if (s == "clear")
	{
		clear();
	}
	else if (s.size() > 5 && s.substr(0, 5) == "loop_")
	{
		init_loop(s.substr(5, s.size()));
	}
	else if (s.size() > 5 && s.substr(0, 5) == "turn_")
	{
		turn(s.substr(5, s.size()));
	}
	else if (s.size() > 10 && s.substr(0, 10) == "draw_rect_")
	{
		draw_rect(s.substr(10, s.size()));
	}
	else if (s.size() > 5 && s.substr(0, 5) == "draw_")
	{
		draw_string(s.substr(5, s.size()));
	}
	else if (s.size() > 13 && s.substr(0, 13) == "change_color_")
	{
		change_color(s.substr(13, s.size()));
	}
	else if (s.size() > 10 && s.substr(0, 10) == "set_delay_")
	{
		set_delay(s.substr(10, s.size()));
	}
	else if (s.size() > 8 && s.substr(0, 8) == "move_to_")
	{
		move_to(s.substr(8, s.size()));
	}
	else if (s.size() > 6 && s.substr(0, 6) == "point:")
	{
		save_point(s.substr(6, s.size()));
	}
	else if (s.size() > 5 && s.substr(0, 5) == "goto:")
	{
		get_point(s.substr(5, s.size()));
	}
	else if (s.size() > 4 && s.substr(0, 4) == "var|")
	{
		save_variable(s.substr(4, s.size()));
	}
	else if (s.size() > 7 && s.substr(0, 7) == "move_x_")
	{
		move_x(s.substr(7, s.size()));
	}
	else if (s.size() > 7 && s.substr(0, 7) == "move_y_")
	{
		move_y(s.substr(7, s.size()));
	}
	else if (s.size() > 6 && s.substr(0, 6) == "print_")
	{
		print(s.substr(6, s.size()));
	}
	else
	{
		throw NoSuchFunctionError(s);
	}
	SDL_RenderPresent(renderer);
}

void Drawer::draw(vector<string> vs)
{
	for (string s : vs)
	{
		draw(s);
		SDL_Delay(delay);
	}
}

void Drawer::pause()
{
	bool pause = true;

	while (pause)
	{
		SDL_Event e;
		while (SDL_PollEvent(&e))
		{
			if (e.type == SDL_KEYDOWN || e.type == SDL_MOUSEBUTTONDOWN)
			{
				pause = false;
			}
		}
	}
}

void Drawer::loop()
{
	for (int i = 0; i < looptimes; ++i)
	{
		draw(loop_strings);
	}
}

void Drawer::to_lower(string& s)
{
	transform(s.begin(), s.end(), s.begin(), ::tolower);
}

void Drawer::transform_vars(string& s)
{
	if (s.size() > 4 && s.substr(0, 4) == "var|")
	{
		return;
	}
	while (s.find("=") != string::npos)
	{
		string name = s.substr(s.find("=")+1, s.size());
		if (name.find(Drawer::SEPARATOR) != string::npos)
		{
			name = s.substr(s.find("=")+1, s.find(Drawer::SEPARATOR));
		}
		string before = s.substr(0, s.find("="));
		string after = s.substr(before.size()+1+name.size(), s.size());

		if (vars.count(name) == 0)
		{
			throw NoSuchVariableError(s);
		}

		s = before + vars[name] + after;
	}
}

void Drawer::clear()
{
	SDL_SetRenderDrawColor(renderer, r, g, b, 255);
	SDL_RenderClear(renderer);
}

void Drawer::turn(string s)
{
	if (s == "right")
	{
		direction += 1;
		if (direction > 3)
		{
			direction = 0;
		}
	}
	else if (s == "left")
	{
		direction -= 1;
		if (direction < 0)
		{
			direction = 3;
		}
	}
	else
	{
		throw NotValidTurnError(s);
	}
}

void Drawer::draw_string(string s)
{
	int pixels;

	iss.str(s);
	iss >> pixels;

	if (iss.fail())
	{
		throw;
	}

	SDL_SetRenderDrawColor(renderer, r, g, b, 255);

	switch(direction)
	{
	case 0:
		SDL_RenderDrawLine(renderer, x, y, x, y - pixels);
		y = y - pixels;
		break;
	case 1:
		//RIGHT
		SDL_RenderDrawLine(renderer, x, y, x + pixels, y);
		x += pixels;
		break;
	case 2:
		//DOWN
		SDL_RenderDrawLine(renderer, x, y, x, y + pixels);
		y += pixels;
		break;
	case 3:
		//LEFT
		SDL_RenderDrawLine(renderer, x, y, x - pixels, y);
		x -= pixels;
		break;
	default:
		break;
		}
}

void Drawer::change_color(string s)
{
	if (s == "random")
	{
		srand(time(NULL));
		r = rand() % 256;
		g = rand() % 256;
		b = rand() % 256;
	}
	else
	{
		vector<int> temp;

		for (int j = 0; j < 3; ++j)
		{
			int temp_i;
			iss.str(s);
			iss >> temp_i;
			if (iss.fail())
			{
				throw;
			}
			temp.push_back(temp_i);
			s = s.substr(s.find("_")+1, s.size());
		}

		r = temp[0];
		g = temp[1];
		b = temp[2];
	}
	SDL_SetRenderDrawColor(renderer, r, g, b, 255);
}

void Drawer::set_delay(string s)
{
	iss.str(s);
	iss >> delay;
}

void Drawer::move_to(string s)
{
	if (s == "center")
	{
		x = SCR_W / 2;
		y = SCR_H / 2;
		return;
	}
	iss.str(s);
	iss >> x;
	s = s.substr(s.find("_")+1, s.size());
	iss.str(s);
	iss >> y;
}

void Drawer::save_point(string s)
{
	points[s] = make_pair(x, y);
}

void Drawer::get_point(string s)
{
	if ( points.count(s) == 0)
	{
		throw NoSuchPointError(s);
	}
	pair<int, int> temp = points.at(s);
	x = temp.first;
	y = temp.second;
}

void Drawer::draw_rect(string s)
{
	SDL_Rect temp = get_square(s);
	cout << temp.x << '\n' << temp.y << '\n' << endl;
	SDL_RenderDrawRect(renderer, &temp);
}

void Drawer::save_variable(string s)
{
	string name = s.substr(0, s.find("="));
	s = s.substr(s.find("=")+1, s.size());
	vars[name] = s;
}

void Drawer::move_x(string s)
{
	iss.str(s);
	int add;
	iss >> add;

	if (iss.fail())
	{
		throw;
	}
	x += add;
}

void Drawer::move_y(string s)
{
	iss.str(s);
	int add;
	iss >> add;

	if (iss.fail())
	{
		throw;
	}

	y += add;
}

void Drawer::init_loop(string s)
{
	looping = true;
	loop_strings.clear();
	iss.str(s);
	iss >> looptimes;

	if (iss.fail())
	{
		throw;
	}
}

void Drawer::update_loop(string s)
{
	if (s == "endloop")
	{
		looping = false;
		loop();
	}
	else
	{
		loop_strings.push_back(s);
	}
}

void Drawer::prompt(string s)
{
	if (looping)
	{
		cout << "GATHERING LOOP: ";
	}
	else
	{
		cout << "TODO: ";
	}
	cout << s << endl;
}

SDL_Rect Drawer::get_square(string s)
{
	int width;
	int height;
	iss.str(s);
	iss >> width;

	if (iss.fail())
	{
		throw CouldNotGetValuesError(s);
	}

	s = s.substr(s.find("_")+1, s.size());
	iss.str(s);
	iss >> height;

	if (iss.fail())
	{
		throw CouldNotGetValuesError(s);
	}

	SDL_Rect temp;
	temp.x = x - (width / 2);
	temp.y = y - (height / 2);
	temp.w = width;
	temp.h = height;

	return temp;
}

void Drawer::clear_render()
{
	clear();
}

void Drawer::set_color(int ri, int gi, int bi)
{
	r = ri;
	g = gi;
	b = bi;
}

void Drawer::draw_char(char c)
{
	string temp;
	stringstream ss;
	ss << c;
	ss >> temp;
	draw_char(temp);
}

void Drawer::draw_char(string c)
{
	draw(get_file_contents("alphabet/" + c + ".txt"));
}

vector<string> Drawer::get_file_contents(string file)
{
	vector<string> temp;
	ifstream ifstr(file);

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
				temp.push_back(line);
			}
		}
	}
	ifstr.close();
	return temp;
}

void Drawer::print(string s)
{
	for (char c : s)
	{
		draw_char(c);
	}
}
