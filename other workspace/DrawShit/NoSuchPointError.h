#ifndef NOSUCHPOINTERROR_H_
#define NOSUCHPOINTERROR_H_

#include <exception>

class NoSuchPointError: public std::exception
{
public:
	NoSuchPointError(std::string s): std::exception(), err(s) {}

	const char* what() const throw()
	{
		return err.c_str();
	}
private:
	std::string err;
};

#endif
