#include <string>
#include <vector>
#include <iostream>

#include "Engine/StateBasedGame.h"
#include "Engine/GameState.h"
#include "States/MainMenuState.h"
#include "NotTerraria.h"
#include "States/PlayState.h"

using namespace std;

int main(int argc, char* argv[])
{
	vector<GameState*> states;
	states.push_back(new MainMenuState());
	states.push_back(new PlayState());

	NotTerraria notTerraria("Not Terraria", make_pair(800, 600), states, 0);
	notTerraria.setTargetDelay(10);
	notTerraria.setExitOnX(true);
	notTerraria.setBlocksize(10);

	return notTerraria.run();
}
