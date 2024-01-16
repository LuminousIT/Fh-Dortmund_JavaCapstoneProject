#### Samuel Olumide Oluwole. (7215275)

### Questions 1
1. What class and method would you use to read a few pieces of data that are at known positions near the end of a large file?

### Answer
We would use the Files.newByteChannel. It returns an instance of SeekableByteChannel which allows you to read from or write to any position in the file.

### Questions 2
2. When invoking format, what is the best way to indicate a new line?

### Answer
The %n conversion 

### Questions 3
3. How would you determine the MIME type of a file?

### Answer
The Files.probeContentType method uses the platform's underlying file type detector to evaluate and return the MIME type.

### Questions 4
4. What method(s) would you use to determine whether a file is a symbolic link?

### Answer
The Files.isSymbolicLink method.