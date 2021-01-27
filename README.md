# List filtering

List filtering is an application that will filter your input list based on another list of filter values.

## Installation

For now no installation possible. This will be made possible in future updates.

## Usage

Run main method

## Example

### Table to be filtered

First header| Second Header
------------- | -------------
Should be removed  | filterThisValue
will not be removed  | will not be removed
Should be removed  | FilterAlsoThisValue

### Entry in values to be filtered

filterThisValue

filterAlsoThisValue

### Program input

Let the program know you want to filter or on Column '2' or on Column with Column name "Second Header"

### What comes out

First header| Second Header
------------- | -------------
Content Cell  | Content Cell


## Contributing

Pull requests are always welcome

## Future

- Instead of java i/o commands I want to change it to any other type of i/o
    -  Being a web page or gui
- For now the input and output are stored in the resources directory of the project
    - best to have a possibility to pick a file from your computer and save a new file to a wanted directory