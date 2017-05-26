#ifndef STATES_SPAWNSTATE_H_
#define STATES_SPAWNSTATE_H_

#include <vector>

#include "../Engine/GameState.h"
#include "../Entities/Player.h"
#include "../Blocks/Block.h"
#include "../Core/TextureHandler.h"
#include "../Core/Image.h"

using Block_Handler = std::map<std::pair<int, int>, Block*>;

class PlayState: public GameState
{
public:
	PlayState();
	~PlayState();

	void init(StateBasedGame* const& sbg);

	void input(StateBasedGame* const& sbg);
	void update(StateBasedGame* const& sbg);
	void render(StateBasedGame* const& sbg);
private:
	bool playerDug;

	Block_Holder blocks;
	Block_Holder currentScreen;

	Player player;

	TextureHandler blockTextures;
	TextureHandler blockHealthTextures;

	void updateBlocks();

	void getCurrentScreen(NotTerraria* const& nt);
};

#endif
