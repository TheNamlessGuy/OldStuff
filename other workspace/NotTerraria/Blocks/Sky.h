#ifndef BLOCKS_SKY_H_
#define BLOCKS_SKY_H_

#include "Block.h"
#include "../NotTerraria.h"

class Sky: public Block
{
public:
	Sky(NotTerraria* const& nt, int x, int y);
	~Sky();

	void update();

	int getID();
};

#endif
