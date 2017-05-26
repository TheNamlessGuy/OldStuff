#include "PlayState.h"
#include <iostream>
#include <random>
#include <SDL2/SDL_image.h>

#include "../NotTerraria.h"

#include "../Blocks/Dirt.h"
#include "../Blocks/Grass.h"
#include "../Blocks/Sky.h"

using namespace std;

PlayState::PlayState()
	: GameState(), playerDug(false), player(), blockTextures(), blockHealthTextures()
{}

PlayState::~PlayState()
{
	for (Block_Holder::iterator iter = blocks.begin(); iter != blocks.end(); ++iter)
	{
		delete (*iter).second;
	}
	blocks.clear();
}

void PlayState::init(StateBasedGame* const& sbg)
{
	NotTerraria* nt = dynamic_cast<NotTerraria*>(sbg);

	player.init(nt->getRenderer(),
			(nt->getWindowWidth() / 2) - nt->getBlocksize(),
			(nt->getWindowHeight() / 2) - nt->getBlocksize(),
			nt->getBlocksize(), (nt->getBlocksize() * 2));

	nt->setScrollY(-12);

	blockTextures.load("res/images/blocks/sky.png", nt->getRenderer());
	blockTextures.load("res/images/blocks/dirt.png", nt->getRenderer());
	blockTextures.load("res/images/blocks/grass.png", nt->getRenderer());

	blockHealthTextures.load("res/images/blocks/hit/1.png", nt->getRenderer());
	blockHealthTextures.load("res/images/blocks/hit/2.png", nt->getRenderer());
	blockHealthTextures.load("res/images/blocks/hit/3.png", nt->getRenderer());
	blockHealthTextures.load("res/images/blocks/hit/4.png", nt->getRenderer());
	blockHealthTextures.load("res/images/blocks/hit/5.png", nt->getRenderer());

	random_device rd;
	uniform_int_distribution<int> uid(0, 100);

	for (int i = 0; i < nt->getWorldWidth() / nt->getBlocksize(); ++i)
	{
		for (int j = 0; j < nt->getWorldHeight() / nt->getBlocksize(); ++j)
		{
			if (j > nt->getTopSpawnLayer() + 1 && uid(rd) > -1)
			{
				blocks[make_pair(i * nt->getBlocksize(), j * nt->getBlocksize())] = new Dirt(nt, i * nt->getBlocksize(), j * nt->getBlocksize());
			}
		}
	}

	/*for (int i = 0; i < nt->getWorldWidth() / nt->getBlocksize(); ++i)
	{
		for (int j = nt->getTopSpawnLayer(); j < nt->getTopSpawnLayer() + 4; ++j)
		{
			if (blocks[make_pair(i * nt->getBlocksize(), j * nt->getBlocksize())] != nullptr)
			{
				blocks[make_pair(i * nt->getBlocksize(), (j - 1) * nt->getBlocksize())] = new Grass(nt, i * nt->getBlocksize(), (j - 1) * nt->getBlocksize());
				break;
			}
		}
	}*/
	for (int i = 0; i < nt->getWorldWidth() / nt->getBlocksize(); ++i)
	{
		blocks[make_pair(i * nt->getBlocksize(), 21 * nt->getBlocksize())] = new Grass(nt, i * nt->getBlocksize(), 21 * nt->getBlocksize());
	}

	for (int i = 0; i < nt->getWorldWidth() / nt->getBlocksize(); ++i)
	{
		for (int j = nt->getTopLayer(); j <= nt->getTopSpawnLayer(); ++j)
		{
			if (blocks[make_pair(i * nt->getBlocksize(), j * nt->getBlocksize())] == nullptr)
			{
				blocks[make_pair(i * nt->getBlocksize(), j * nt->getBlocksize())] = new Sky(nt, i * nt->getBlocksize(), j * nt->getBlocksize());
			}
		}
	}
}

void PlayState::input(StateBasedGame* const& sbg)
{
	NotTerraria* nt = dynamic_cast<NotTerraria*>(sbg);
	player.input(nt, currentScreen, playerDug);

	if (nt->isKeyDown(SDLK_ESCAPE))
	{
		nt->exit();
	}
}

void PlayState::update(StateBasedGame* const& sbg)
{
	NotTerraria* nt = dynamic_cast<NotTerraria*>(sbg);

	player.update(nt, currentScreen);

	if (playerDug)
	{
		for (int i = nt->getScrollX(); i < nt->getScrollX() + nt->getWindowWidth() / nt->getBlocksize(); ++i)
		{
			for (int j = nt->getScrollY(); j < nt->getScrollY() + nt->getWindowHeight() / nt->getBlocksize(); ++j)
			{
				blocks[make_pair(i * nt->getBlocksize(), j * nt->getBlocksize())] = currentScreen[make_pair(i * nt->getBlocksize(), j * nt->getBlocksize())];
			}
		}
		playerDug = false;
	}
	getCurrentScreen(nt);
	updateBlocks();
}

void PlayState::render(StateBasedGame* const& sbg)
{
	NotTerraria* nt = dynamic_cast<NotTerraria*>(sbg);

	for (int i = nt->getScrollX(); i < nt->getScrollX() + nt->getWindowWidth() / nt->getBlocksize(); ++i)
	{
		for (int j = nt->getScrollY(); j < nt->getScrollY() + nt->getWindowHeight() / nt->getBlocksize(); ++j)
		{
			Block* block = currentScreen[make_pair(i * nt->getBlocksize(), j * nt->getBlocksize())];
			if (block != nullptr)
			{
				block->render((i - nt->getScrollX()) * nt->getBlocksize(),
						(j - nt->getScrollY()) * nt->getBlocksize(),
						sbg->getRenderer(),
						blockTextures.getTexture(block->getID()),
						blockHealthTextures);
			}
		}
	}
	player.render(sbg->getRenderer());
}

void PlayState::getCurrentScreen(NotTerraria* const& nt)
{
	currentScreen.clear();

	for (int i = nt->getScrollX(); i < nt->getScrollX() + nt->getWindowWidth() / nt->getBlocksize(); ++i)
	{
		for (int j = nt->getScrollY(); j < nt->getScrollY() + nt->getWindowHeight() / nt->getBlocksize(); ++j)
		{
			currentScreen[make_pair(i * nt->getBlocksize(), j * nt->getBlocksize())] = blocks[make_pair(i * nt->getBlocksize(), j * nt->getBlocksize())];
		}
	}
}

void PlayState::updateBlocks()
{
	for (Block_Holder::iterator iter = currentScreen.begin(); iter != currentScreen.end(); ++iter)
	{
		if ((*iter).second != nullptr)
		{
			(*iter).second->update();
		}
	}
}
