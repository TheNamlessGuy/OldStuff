#include "Grass.h"

using namespace std;

Grass::Grass(NotTerraria* const& nt, int x, int y)
	:Block(10, x, y, nt->getBlocksize(), nt->getBlocksize())
{}

Grass::~Grass()
{}

void Grass::update()
{
	--resetTimer;
	if (resetTimer <= 0)
	{
		health = maxHealth;
	}
}

int Grass::getID()
{
	return 2;
}
