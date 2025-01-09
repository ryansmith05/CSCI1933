// Written by Ryan Smith, smi01810
// Written by Anna Chen, chen7375

Group members:
    - name: Ryan Smith, x500: smi01810, email: smi01810@d.umn.edu
    - name: Anna Chen, x500: chen7375, email: chen7375@umn.edu

Contributions of each partner:
    - HashTable.java
        - The Constructor - chen7375 (Anna)
        - Hash method - smi01810 and chen7375 (Ryan and Anna)
        - Add method - smi01810 and chen7375 (Ryan and Anna)
        - Main Method - smi01810 (Ryan)
    - README.txt: smi01810 and chen7375 (Ryan and Anna)

How to compile and run the program:
    - You must compile the java file HashTable and then run the program to get the outcomes

Any assumptions:
    - None that we can think of.

Additional features that your HashTable has (if applicable)
    -  None

Any known bugs:
    - None that we are aware of

Any outside sources:
    - Used notes from Dovolis's lecture on Hash Tables
    - TA help during lab for the add method

Integrity statement:
    -“I certify that the information contained in this README
      file is complete and accurate. I have both read and followed the course policies
      in the ‘Academic Integrity - Course Policy’ section of the course syllabus.”
        - Ryan Smith
        - Anna Chen

Output from your hash table for each given file.
    - canterbury.txt output/results
        - # unique words: 208
        - # empty indices: 116
        - # nonempty indices: 134
        - average collision length: 1.5522388059701493
        - length of longest chain: 5
    - gettysburg.txt output/results
        - # unique words: 150
        - # empty indices: 132
        - # nonempty indices: 118
        - average collision length: 1.271186440677966
        - length of longest chain: 5
    - keywords.txt output/results
        - # unique words: 50
        - # empty indices: 205
        - # nonempty indices: 45
        - average collision length: 1.1111111111111112
        - length of longest chain: 2

A brief description of your hash function and its operation
    - uses the built-in toString() method to convert the object to a string. It then iterates over each character in the string using
      a for loop, computing a running sum based on the character's Unicode value. The final value of hashVal is obtained by taking the
      modulo of the sum with the size/length of the hash table. This ensures that hashVal falls within the range of valid indices
      for the hash table. The HashVal is then the index that it will be added to in the Hash Table. The add function adds a given item
      to the hash table using our hash function. It does not add duplicated items, and it links items together that have the same hashVal
      (collisions) creating a chain/linked list at that specific index.
