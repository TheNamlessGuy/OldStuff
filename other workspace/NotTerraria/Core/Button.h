#ifndef HEADERS_BUTTON_H_
#define HEADERS_BUTTON_H_

#include <vector>
#include <string>
#include <SDL2/SDL.h>

#include "Image.h"

class Button
{
public:
	Button(int const& x_i, int const& y_i, std::string const& filename, SDL_Renderer* const& r);
	~Button();

	bool is_hover(int const& mouse_x, int const& mouse_y) const;
	bool is_hover() const;

	void set_hover(bool const& hovering);
	void render(SDL_Renderer* const& r) const;

	SDL_Rect& get_hitbox();
private:
	Image* not_hover_img;
	Image* hover_img;
	Image* current;

	int x;
	int y;
	int width;
	int height;
};

#endif
