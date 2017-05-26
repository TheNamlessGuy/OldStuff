#include "Dirt.h"

using namespace std;

Dirt::Dirt(NotTerraria* const& nt, int x, int y)
	:Block(10, x, y, nt->getBlocksize(), nt->getBlocksize())
{}

Dirt::~Dirt()
{}

void Dirt::update()
{
	--resetTimer;
	if (resetTimer <= 0)
	{
		health = maxHealth;
	}
}

int Dirt::getID()
{
	return 1;
}
