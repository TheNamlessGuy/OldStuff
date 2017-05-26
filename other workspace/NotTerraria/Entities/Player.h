#ifndef ENTITIES_PLAYER_H_
#define ENTITIES_PLAYER_H_

#include <SDL2/SDL.h>

#include "../NotTerraria.h"
#include "../Blocks/Block.h"

using Block_Holder = std::map<std::pair<int, int>, Block*>;

class Player
{
public:
	Player();
	~Player();

	void init(SDL_Renderer* const& r, int x, int y, int w, int h);

	void input(NotTerraria* const& sbg, Block_Holder& blocks, bool& dug);
	void update(NotTerraria* const& sbg, Block_Holder& blocks);
	void render(SDL_Renderer* const& r) const;

	void moveTo(int x, int y);

	SDL_Rect& getHitbox();

	bool isOutOfBounds(std::pair<int, int> const& gamescreen) const;
private:
	SDL_Rect player;
	SDL_Rect centerPoint;

	SDL_Texture* texture;

	bool falling;
	bool jumping;
	bool inAir;
	bool running;
	bool sneaking;
	bool facingLeft;

	short jumpDistance;
	short fatigue;
	short jumpDelay;

	float moveSpeed;

	void jump(NotTerraria* const& sbg, Block_Holder& blocks);
	void fall(NotTerraria* const& sbg, Block_Holder& blocks);
	void dig(NotTerraria* const& sbg, Block_Holder& blocks, bool& dug);
	void moveLeft(NotTerraria* const& sbg, Block_Holder& blocks);
	void moveRight(NotTerraria* const& sbg, Block_Holder& blocks);

	bool nothingY(NotTerraria* const& sbg, Block_Holder& blocks, int y);
	bool nothingX(NotTerraria* const& sbg, Block_Holder& blocks, int x);

	bool isStandingInBlock(NotTerraria* const& sbg, Block_Holder& blocks);

	SDL_Rect getDiggingAura(NotTerraria* const& sbg);
};

#endif
