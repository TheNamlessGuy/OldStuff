#ifndef STATES_MAINMENUSTATE_H_
#define STATES_MAINMENUSTATE_H_

#include "../Engine/GameState.h"
#include "../Core/Button.h"

class MainMenuState: public GameState
{
public:
	MainMenuState();
	~MainMenuState();

	void init(StateBasedGame* const& sbg);

	void input(StateBasedGame* const& sbg);
	void update(StateBasedGame* const& sbg);
	void render(StateBasedGame* const& sbg);
private:
	Button* play;
	Button* quit;
};

#endif
