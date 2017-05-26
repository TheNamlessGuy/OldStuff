#include "Sky.h"

Sky::Sky(NotTerraria* const& nt, int x, int y)
	:Block(-1, x, y, nt->getBlocksize(), nt->getBlocksize())
{}

Sky::~Sky()
{}

void Sky::update()
{}

int Sky::getID()
{
	return 0;
}
