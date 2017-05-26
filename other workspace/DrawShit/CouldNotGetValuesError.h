#ifndef COULDNOTGETVALUESERROR_H_
#define COULDNOTGETVALUESERROR_H_

#include <exception>

class CouldNotGetValuesError: public std::exception
{
public:
	CouldNotGetValuesError(std::string s): std::exception(), err(s) {}

	const char* what() const throw()
	{
		return err.c_str();
	}
private:
	std::string err;
};

#endif
