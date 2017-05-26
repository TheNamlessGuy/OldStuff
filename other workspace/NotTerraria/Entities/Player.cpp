#include <SDL2/SDL_image.h>
#include <cmath>
#include <iostream>

#include "Player.h"
#include "../Blocks/Sky.h"

using namespace std;

Player::Player()
	:texture(nullptr),
	 falling(true), jumping(false), inAir(false),
	 running(false), sneaking(false), facingLeft(false),
	 jumpDistance(0), fatigue(0), jumpDelay(0), moveSpeed(0.5)
{}

Player::~Player()
{
	SDL_DestroyTexture(texture);
	texture = nullptr;
}

void Player::init(SDL_Renderer* const& r, int x, int y, int w, int h)
{
	player.x = x;
	player.y = y;
	player.w = w;
	player.h = h;

	centerPoint = player;

	SDL_Surface* surf = IMG_Load("res/images/player.png");
	texture = SDL_CreateTextureFromSurface(r, surf);
	SDL_FreeSurface(surf);
}

void Player::input(NotTerraria* const& sbg, Block_Holder& blocks, bool& dug)
{
	if (sbg->isKeyDown(SDLK_UP))
	{
		sbg->setScrollY(sbg->getScrollY() - 1);
	}
	if (sbg->isKeyDown(SDLK_DOWN))
	{
		sbg->setScrollY(sbg->getScrollY() + 1);
	}
	if (sbg->isKeyDown(SDLK_RIGHT))
	{
		sbg->setScrollX(sbg->getScrollX() + 1);
	}
	if (sbg->isKeyDown(SDLK_LEFT))
	{
		sbg->setScrollX(sbg->getScrollX() - 1);
	}
	if (sbg->isKeyDown(SDLK_d))
	{
		moveRight(sbg, blocks);
	}

	if (sbg->isKeyDown(SDLK_a))
	{
		moveLeft(sbg, blocks);
	}

	if (sbg->isKeyDown(SDLK_w) && !inAir && jumpDelay <= 0)
	{
		jumping = true;
	}

	if (sbg->isKeyDown(SDLK_LSHIFT) && !running)
	{
		running = true;
		moveSpeed *= 2;
	}
	else if (running)
	{
		running = false;
		moveSpeed /= 2;
	}

	if (sbg->isKeyDown(SDLK_LCTRL) && !sneaking)
	{
		sneaking = true;
		moveSpeed /= 2;
	}
	else if (sneaking)
	{
		sneaking = false;
		moveSpeed *= 2;
	}

	if (sbg->isKeyDown(SDLK_r))
	{
		sbg->setScrollX(0);
		sbg->setScrollY(-12);
	}

	/*if (sbg->isKeyDown(SDLK_0))
	{
		moveSpeed = 0.1f;
	}
	else if (sbg->isKeyDown(SDLK_KP_0))
	{
		moveSpeed = 0.2f;
	}
	else if (sbg->isKeyDown(SDLK_KP_1))
	{
		moveSpeed = 0.3f;
	}
	else if (sbg->isKeyDown(SDLK_KP_2))
	{
		moveSpeed = 0.4f;
	}
	else if (sbg->isKeyDown(SDLK_KP_3))
	{
		moveSpeed = 0.5f;
	}
	else if (sbg->isKeyDown(SDLK_KP_4))
	{
		moveSpeed = 0.6f;
	}
	else if (sbg->isKeyDown(SDLK_KP_5))
	{
		moveSpeed = 0.7f;
	}
	else if (sbg->isKeyDown(SDLK_KP_6))
	{
		moveSpeed = 0.8f;
	}
	else if (sbg->isKeyDown(SDLK_KP_7))
	{
		moveSpeed = 0.9f;
	}
	else if (sbg->isKeyDown(SDLK_KP_8))
	{
		moveSpeed = 1;
	}*/

	if (sbg->isMouseButtonDown())// && fatigue <= 0)
	{
		dig(sbg, blocks, dug);
	}
}

void Player::update(NotTerraria* const& sbg, Block_Holder& blocks)
{
	fatigue -= 1;
	jumpDelay -= 1;

	while (isStandingInBlock(sbg, blocks))
	{
		cout << "STUCK" << endl;
		if (facingLeft)
		{
			moveRight(sbg, blocks);
			facingLeft = true;
		}
		else
		{
			moveLeft(sbg, blocks);
			facingLeft = false;
		}
	}

	if (nothingY(sbg, blocks, player.y + player.h) && !sbg->isKeyDown(SDLK_e))
	{
		falling = true;
	}
	else
	{
		falling = false;
		inAir = false;
	}

	if (jumping)
	{
		jump(sbg, blocks);
	}
	else if (falling)
	{
		fall(sbg, blocks);
	}
}

void Player::render(SDL_Renderer* const& r) const
{
	SDL_RendererFlip flip = SDL_FLIP_NONE;

	if (facingLeft)
	{
		flip = SDL_FLIP_HORIZONTAL;
	}

	SDL_RenderCopyEx(r, texture, nullptr, &player, 0, nullptr, flip);
}

void Player::moveTo(int x, int y)
{
	player.x = x;
	player.y = y;

	falling = true;
	jumping = false;
	inAir = false;

	jumpDistance = 0;
}

SDL_Rect& Player::getHitbox()
{
	return player;
}

void Player::jump(NotTerraria* const& sbg, Block_Holder& blocks)
{
	inAir = true;

	if (nothingY(sbg, blocks, player.y - sbg->getBlocksize()) && jumpDistance < 20)
	{
		sbg->setScrollY(sbg->getScrollY() - 0.5);
		jumpDistance++;
	}
	else
	{
		jumping = false;
		jumpDistance = 0;
		jumpDelay = 40;

		falling = true;
	}
}

void Player::fall(NotTerraria* const& sbg, Block_Holder& blocks)
{
	inAir = true;
	sbg->setScrollY(sbg->getScrollY() + 0.5);
}

bool Player::isOutOfBounds(pair<int, int> const& gamescreen) const
{
	return (player.y > gamescreen.second || player.y < 0) ||
			(player.x > gamescreen.first || player.x < 0);
}

void Player::moveLeft(NotTerraria* const& sbg, Block_Holder& blocks)
{
	if (nothingX(sbg, blocks, player.x - sbg->getBlocksize()))
	{
		if ((sbg->getScrollX() * sbg->getBlocksize()) + sbg->getWindowWidth() >= sbg->getWorldWidth() &&
				player.x > centerPoint.x)
		{
			player.x -= moveSpeed * sbg->getBlocksize();
		}
		else if (sbg->getScrollX() > 0)
		{
			player = centerPoint;
			sbg->setScrollX(sbg->getScrollX() - moveSpeed);
		}
		else if (player.x > 0)
		{
			player.x -= moveSpeed * sbg->getBlocksize();
		}
		facingLeft = true;
	}
}

void Player::moveRight(NotTerraria* const& sbg, Block_Holder& blocks)
{
	if (nothingX(sbg, blocks, player.x + player.w))
	{
		if (sbg->getScrollX() <= 0 && player.x < centerPoint.x)
		{
			player.x += moveSpeed * sbg->getBlocksize();
		}
		else if ((sbg->getScrollX() * sbg->getBlocksize()) + sbg->getWindowWidth() < sbg->getWorldWidth())
		{
			player = centerPoint;
			sbg->setScrollX(sbg->getScrollX() + moveSpeed);
		}
		else if (player.x + player.w < sbg->getWindowWidth())
		{
			player.x += moveSpeed * sbg->getBlocksize();
		}
		facingLeft = false;
	}
}

bool Player::nothingY(NotTerraria* const& sbg, Block_Holder& blocks, int y)
{
	for (int i = player.x - sbg->getBlocksize() + 1; i < player.x + player.w; ++i)
	{
		Block* block = blocks[make_pair(sbg->getScrollX() * sbg->getBlocksize() + i,
				sbg->getScrollY() * sbg->getBlocksize() + y)];
		Sky* skyTest = dynamic_cast<Sky*>(block);
		if (block != nullptr && skyTest == nullptr)
		{
			return false;
		}
	}
	return true;
}

bool Player::nothingX(NotTerraria* const& sbg, Block_Holder& blocks, int x)
{
	for (int i = player.y - sbg->getBlocksize() + 1; i < player.y + player.h; ++i)
	{
		Block* block = blocks[make_pair(sbg->getScrollX() * sbg->getBlocksize() + x,
				sbg->getScrollY() * sbg->getBlocksize() + i)];
		Sky* skyTest = dynamic_cast<Sky*>(block);
		if (block != nullptr && skyTest == nullptr)
		{
			return false;
		}
	}
	return true;
}

SDL_Rect Player::getDiggingAura(NotTerraria* const& sbg)
{
	SDL_Rect diggingAura = getHitbox();
	diggingAura.x -= 3 * sbg->getBlocksize();
	diggingAura.y -= 3 * sbg->getBlocksize();
	diggingAura.w += 6 * sbg->getBlocksize();
	diggingAura.h += 6 * sbg->getBlocksize();

	return diggingAura;
}

void Player::dig(NotTerraria* const& sbg, Block_Holder& blocks, bool& dug)
{
	SDL_Rect diggingAura = getDiggingAura(sbg);
	SDL_Rect mousePos = sbg->getMousePosAsRect();

	if (!SDL_HasIntersection(&mousePos, &diggingAura))
	{
		return;
	}

	mousePos.x += sbg->getScrollX() * sbg->getBlocksize();
	mousePos.y += sbg->getScrollY() * sbg->getBlocksize();

	while (mousePos.x % sbg->getBlocksize() != 0)
	{
		--mousePos.x;
	}

	while (mousePos.y % sbg->getBlocksize() != 0)
	{
		--mousePos.y;
	}

	Block* block = blocks[make_pair(mousePos.x, mousePos.y)];
	Sky* skyTest = dynamic_cast<Sky*>(block);
	if (block != nullptr && skyTest == nullptr)
	{
		block->hit();

		//fatigue = 25;

		if (block->getHealth() <= 0)
		{
			delete blocks[make_pair(mousePos.x, mousePos.y)];
			blocks[make_pair(mousePos.x, mousePos.y)] = nullptr;
			dug = true;
		}
	}
}

bool Player::isStandingInBlock(NotTerraria* const& sbg, Block_Holder& blocks)
{
	for (int i = player.x - sbg->getBlocksize() + 1; i < player.x + player.w; ++i)
	{
		for (int j = player.y; j < player.y + player.h; ++j)
		{
			Block* block = blocks[make_pair(sbg->getScrollX() * sbg->getBlocksize() + i,
					sbg->getScrollY() * sbg->getBlocksize() + j)];
			Sky* skyTest = dynamic_cast<Sky*>(block);
			if (block != nullptr && skyTest == nullptr)
			{
				return true;
			}
		}
	}
	return false;
}
