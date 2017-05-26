#ifndef NOTVALIDTURNERROR_H_
#define NOTVALIDTURNERROR_H_

#include <exception>

class NotValidTurnError: public std::exception
{
public:
	NotValidTurnError(std::string s): std::exception(), err(s) {}

	const char* what() const throw()
	{
		return err.c_str();
	}
private:
	std::string err;
};

#endif
