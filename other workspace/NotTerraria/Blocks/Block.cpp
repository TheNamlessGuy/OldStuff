#include <iostream>

#include "Block.h"

using namespace std;

Block::Block(int health_i, int x, int y, int w, int h)
	:health(health_i), maxHealth(health_i), resetTimer(0)
{
	hitbox.x = x;
	hitbox.y = y;
	hitbox.w = w;
	hitbox.h = h;
}

Block::~Block()
{}

void Block::render(SDL_Renderer* const& r, SDL_Texture* texture, TextureHandler& hitTextures)
{
	SDL_RenderCopy(r, texture, nullptr, &hitbox);

	if (health == maxHealth || health < 0)
	{
		return;
	}
	else if (health >= (maxHealth / 5) * 4)
	{
		SDL_RenderCopy(r, hitTextures.getTexture(0), nullptr, &hitbox);
	}
	else if (health >= (maxHealth / 5) * 3)
	{
		SDL_RenderCopy(r, hitTextures.getTexture(1), nullptr, &hitbox);
	}
	else if (health >= (maxHealth / 5) * 2)
	{
		SDL_RenderCopy(r, hitTextures.getTexture(2), nullptr, &hitbox);
	}
	else if (health >= (maxHealth / 5) * 1)
	{
		SDL_RenderCopy(r, hitTextures.getTexture(3), nullptr, &hitbox);
	}
	else
	{
		SDL_RenderCopy(r, hitTextures.getTexture(4), nullptr, &hitbox);
	}
}
void Block::render(int x, int y, SDL_Renderer* const& r, SDL_Texture* texture, TextureHandler& hitTextures)
{
	int oldX = hitbox.x;
	int oldY = hitbox.y;

	hitbox.x = x;
	hitbox.y = y;

	render(r, texture, hitTextures);

	hitbox.x = oldX;
	hitbox.y = oldY;
}

void Block::hit()
{
	health--;
	resetTimer = 50;
}

int Block::getHealth()
{
	return health;
}

SDL_Rect& Block::getHitbox()
{
	return hitbox;
}
