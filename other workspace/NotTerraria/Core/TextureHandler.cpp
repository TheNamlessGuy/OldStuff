#include <SDL2/SDL_image.h>

#include "TextureHandler.h"

using namespace std;

TextureHandler::TextureHandler()
{}

TextureHandler::~TextureHandler()
{
	for (SDL_Texture* texture: textures)
	{
		delete texture;
	}
	textures.clear();
}

void TextureHandler::load(string location, SDL_Renderer* r)
{
	SDL_Texture* tex;
	SDL_Surface* surf = IMG_Load(location.c_str());
	tex = SDL_CreateTextureFromSurface(r, surf);
	SDL_FreeSurface(surf);

	textures.push_back(tex);
	tex = nullptr;
}

SDL_Texture* TextureHandler::getTexture(int index)
{
	return textures.at(index);
}
