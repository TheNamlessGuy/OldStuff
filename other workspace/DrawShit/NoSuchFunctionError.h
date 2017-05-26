#ifndef NOSUCHFUNCTIONERROR_H_
#define NOSUCHFUNCTIONERROR_H_

#include <exception>
#include <string>

class NoSuchFunctionError: public std::exception
{
public:
	NoSuchFunctionError(std::string s) throw(): std::exception(), err(s) {}

	const char* what() const throw()
	{
		return err.c_str();
	}
private:
	std::string err;
};

#endif
