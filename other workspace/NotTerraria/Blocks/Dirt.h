#ifndef BLOCKS_DIRT_H_
#define BLOCKS_DIRT_H_

#include "Block.h"
#include "../NotTerraria.h"

class Dirt: public Block
{
public:
	Dirt(NotTerraria* const& nt, int x, int y);
	~Dirt();

	void update();

	int getID();
};

#endif
