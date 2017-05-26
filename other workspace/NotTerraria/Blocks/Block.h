#ifndef BLOCKS_BLOCK_H_
#define BLOCKS_BLOCK_H_

#include <SDL2/SDL.h>

#include "../Core/TextureHandler.h"

class Block
{
public:
	Block(int health, int x, int y, int w, int h);
	virtual ~Block();

	virtual void update() = 0;
	virtual void render(SDL_Renderer* const& r, SDL_Texture* texture, TextureHandler& hitTextures);
	virtual void render(int x, int y, SDL_Renderer* const& r, SDL_Texture* texture, TextureHandler& hitTextures);
	virtual void hit();

	virtual int getHealth();

	virtual SDL_Rect& getHitbox();

	virtual int getID() = 0;
protected:
	SDL_Rect hitbox;
	int health, maxHealth, resetTimer;
};

#endif
