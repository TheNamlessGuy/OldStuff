#ifndef DRAWER_H_
#define DRAWER_H_

#include <vector>
#include <string>
#include <map>
#include <sstream>
#include <SDL2/SDL.h>

class Drawer
{
public:

	static const int SCR_W = 800;
	static const int SCR_H = 600;

	static const char SEPARATOR = '_';

	static const int EAST = 0;
	static const int SOUTHEAST = 1;
	static const int SOUTH = 2;
	static const int SOUTHWEST = 3;
	static const int WEST = 4;
	static const int NORTHWEST = 5;
	static const int NORTH = 6;
	static const int NORTHEAST = 7;

	Drawer();
	~Drawer();

	void init();
	void end();
	void draw(std::string);
	void draw(std::vector<std::string>);
	void pause();
	void clear_render();
	void set_color(int ri, int gi, int bi);
	void draw_char(char c);
	void draw_char(std::string c);
	std::vector<std::string> get_file_contents(std::string file);
private:
	std::istringstream iss;

	int direction;
	int delay;
	int x, y;
	int r, g, b;

	std::map<std::string, std::pair<int, int> > points;
	std::map<std::string, std::string> vars;

	SDL_Window* window;
	SDL_Renderer* renderer;

	bool looping;
	int looptimes;
	std::vector<std::string> loop_strings;

	void prompt(std::string);

	void to_lower(std::string&);
	void transform_vars(std::string&);

	void loop();
	void init_loop(std::string);
	void update_loop(std::string);

	SDL_Rect get_square(std::string);

	void clear();
	void turn(std::string);
	void draw_string(std::string);
	void change_color(std::string);
	void set_delay(std::string);
	void move_to(std::string);
	void save_point(std::string);
	void get_point(std::string);
	void draw_rect(std::string);
	void save_variable(std::string);
	void move_x(std::string);
	void move_y(std::string);
	void print(std::string);
};

#endif
