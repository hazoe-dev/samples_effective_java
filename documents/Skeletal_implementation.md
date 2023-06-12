# Skeletal implementation 
## Abstract && interface
### Define a type
- 2 mechanisms for defining a type that permits multiple implementations: abstract and interface.
### Abstract
- Contain implementations  
- Implement class must be subclassed   
=> Because Java has only single inheritance.
### Interface
- There is no implementation.
- Using any class even out of class hierarchy.  
- Interfaces is ideal for mixins = multiple inheritance.   
Mixin is a type that a class can change primary function such as Comparable.
- Interface allow construction with non-hierarchical type.  Example: Singer; SongWriter; SingerSongWriter.  
=> avoid combinatorial explosion
- Interface enable safe, powerful functionality enhancement.  Inheritance need document and design to subclasses override safely, prefer composition to inheritance.
### Skeletal implementation
Compile advantages of abstract class and interface into skeletal implementation.  
This is abstract interface.  
By convention, the class names are Abstract*Interface*.   
The interface that is importance you want to export.  
Such as: AbstractMap, AbstractList, AbstractCollection ...

- Abstract class can be replaced by class when you do not want to constraint override method for subclasses.
- You have implementations of abstract without imposing constraint that is subclass.  
=> Do not need to override all methods manually.
- When forwarding invocation of interface method to contained instance of a private inner class extends skeletal implementation   
=> simulated multiple inheritance 
- It is easier to evolve an abstract class than an interface.  
Adding a new method into interface lead to breaking all its implement class => these class need to override new method  
But abstract class can support a default method  
=> this is limit break for the classes do not need to override new method.  
Therefore, take carefully before export a method of interface. You can implement as much as possibly to find flaws when you can correct  

Example code for skeletal implementation:
https://github.com/hazoe-dev/samples_effective_java/tree/skeletal_implementation/src/main/java/skeletal_implementation