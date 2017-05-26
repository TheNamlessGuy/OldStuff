#ifndef NOTTERRARIA_H_
#define NOTTERRARIA_H_

#include "Engine/StateBasedGame.h"

class NotTerraria: public StateBasedGame
{
public:
	NotTerraria(std::string title,
			std::pair<int, int> screen,
			std::vector<GameState*> states,
			int startingState);
	~NotTerraria();

	int getTopSpawnLayer();
	int getTopLayer();
	int getBlocksize();
	void setBlocksize(int blocksize);

	int getWorldWidth();
	int getWorldHeight();
	std::pair<int, int> getWorldSize();

	float getScrollX();
	float getScrollY();
	void setScrollX(float newScrollX);
	void setScrollY(float newScrollY);
private:
	int blocksize;

	float scrollX, scrollY;
};

#endif
