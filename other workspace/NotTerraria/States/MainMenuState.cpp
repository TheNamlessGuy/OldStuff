#include <iostream>

#include "MainMenuState.h"

using namespace std;

MainMenuState::MainMenuState()
	: GameState(),
	  play(nullptr), quit(nullptr)
{}

MainMenuState::~MainMenuState()
{
	delete play;
	delete quit;
}

void MainMenuState::init(StateBasedGame* const& sbg)
{
	play = new Button((sbg->getWindowWidth() / 2) - 50, (sbg->getWindowHeight() / 2) - 100,
			"res/images/buttons/play.png", sbg->getRenderer());
	quit = new Button((sbg->getWindowWidth() / 2) - 50, (sbg->getWindowHeight() / 2) + 50,
			"res/images/buttons/quit.png", sbg->getRenderer());
}

void MainMenuState::input(StateBasedGame* const& sbg)
{
	if (sbg->isKeyDown(SDLK_ESCAPE))
	{
		sbg->exit();
	}
	if (sbg->isKeyDown(SDLK_RETURN))
	{
		sbg->changeState(1);
	}
}

void MainMenuState::update(StateBasedGame* const& sbg)
{
	pair<int, int> mousePos = sbg->getMousePosition();
	play->set_hover(play->is_hover(mousePos.first, mousePos.second));
	quit->set_hover(quit->is_hover(mousePos.first, mousePos.second));

	if (sbg->isMouseButtonDown() && play->is_hover())
	{
		sbg->changeState(1);
	}
	else if (sbg->isMouseButtonDown() && quit->is_hover())
	{
		sbg->exit();
	}
}

void MainMenuState::render(StateBasedGame* const& sbg)
{
	SDL_Rect temp = play->get_hitbox();
	SDL_SetRenderDrawColor(sbg->getRenderer(), 255, 0, 0, 255);
	SDL_RenderDrawRect(sbg->getRenderer(), &temp);

	play->render(sbg->getRenderer());
	quit->render(sbg->getRenderer());

	SDL_SetRenderDrawColor(sbg->getRenderer(), 0, 0, 255, 255);
	SDL_RenderDrawLine(sbg->getRenderer(), sbg->getWindowWidth() / 2, 0,
			sbg->getWindowWidth() / 2, sbg->getWindowHeight());
	SDL_RenderDrawLine(sbg->getRenderer(), 0, sbg->getWindowHeight() / 2,
			sbg->getWindowWidth(), sbg->getWindowHeight() / 2);
}
