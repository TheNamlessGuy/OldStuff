#ifndef CORE_TEXTUREHANDLER_H_
#define CORE_TEXTUREHANDLER_H_

#include <SDL2/SDL.h>
#include <vector>
#include <string>

class TextureHandler
{
public:
	TextureHandler();
	~TextureHandler();

	void load(std::string location, SDL_Renderer* r);
	SDL_Texture* getTexture(int index);
private:
	std::vector<SDL_Texture*> textures;
};

#endif
