#ifndef BLOCKS_GRASS_H_
#define BLOCKS_GRASS_H_

#include "Block.h"
#include "../NotTerraria.h"

class Grass: public Block
{
public:
	Grass(NotTerraria* const& nt, int x, int y);
	~Grass();

	void update();

	int getID();
};

#endif
