# def common_chr(word):
#     dictionary = {}
#     for i in word:
#         if i in dictionary:
#             dictionary[i] += 1
#         else:
#             dictionary[i] = 1

# from collections import Counter

# def MostCommonChr():
#     userInput = input('Enter a word: ')
#     res = Counter(userInput)
#     letter = max(res, key = res.get)
#     number = res.get(letter)
#     return (letter, number)

# def is_palindrome(word):
#     if word == word[::-1]:
#         return True
#     else: 
#         return False
# if __name__ == '__main__':
#     print(is_palindrome('car'))
#     print(is_palindrome('racecar'))

import math
class Circle:
    def __init__(self, radius):
        self.radius = radius

    def getRadius(self):
        return self.radius
    
    def setRadius(self, new_radius):
        self.radius = new_radius 

    def getArea(self):
        return math.pi * self.radius**2
    
    def getDiameter(self):
        return self.radius * 2

    def getCircumference(self):
        return 2 * math.pi * self.radius

    def __eq__ (self, other):
        return self.radius == other.radius

circle1 = Circle(5)
circle2 = Circle(5)

print("The Area of circle1 is", circle1.getArea())
print("The Area of circle2 is", circle2.getArea())
print("The diameter of circle1 is", circle1.getDiameter())
print("The diameter of circle2 is", circle2.getDiameter())
print("The circumference of circle1 is", circle1.getCircumference())
print("The circumference of circle2 is", circle2.getCircumference())
print("Is circle1 and circle2 have same radius:", circle1 == circle2)