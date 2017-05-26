#ifndef NOSUCHVARIABLEERROR_H_
#define NOSUCHVARIABLEERROR_H_

#include <exception>

class NoSuchVariableError: public std::exception
{
public:
	NoSuchVariableError(std::string s): std::exception(), err(s) {}

	const char* what() const throw()
	{
		return err.c_str();
	}
private:
	std::string err;
};

#endif
