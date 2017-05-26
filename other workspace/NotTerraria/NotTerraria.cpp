#include "NotTerraria.h"

NotTerraria::NotTerraria(std::string title,
			std::pair<int, int> screen,
			std::vector<GameState*> states,
			int startingState)
	:StateBasedGame(title, screen, states, startingState),
	 blocksize(0), scrollX(0), scrollY(0)
{}

NotTerraria::~NotTerraria()
{}

int NotTerraria::getBlocksize()
{
	return blocksize;
}

void NotTerraria::setBlocksize(int blocksize_i)
{
	blocksize = blocksize_i;
}

int NotTerraria::getWorldHeight()
{
	return 1000;
}

int NotTerraria::getWorldWidth()
{
	return 100000;
}

std::pair<int, int> NotTerraria::getWorldSize()
{
	return std::make_pair(getWorldWidth(), getWorldHeight());
}

int NotTerraria::getTopSpawnLayer()
{
	return 20;
}

int NotTerraria::getTopLayer()
{
	return -20;
}

float NotTerraria::getScrollX()
{
	return scrollX;
}

float NotTerraria::getScrollY()
{
	return scrollY;
}

void NotTerraria::setScrollX(float newScrollX)
{
	scrollX = newScrollX;
}

void NotTerraria::setScrollY(float newScrollY)
{
	scrollY = newScrollY;
}
