#Template Method模式
将具体的处理交给子类

是指带有模板功能的模式，组成模板的方法被定义在父类中。
这些方法都是抽象方法，实现上述这些方法是子类，像这样在父类定义处理流程的框架
,在子类中实现具体处理的模式就被称为Template Method模式

演示见代码

###Template Method模式中的角色

####AbstractClass抽象类

AbstractClass不仅负责实现模板方法，还负责声明在模板方法中所用到的抽象方法，
这些抽象方法由子类（ConCreteClass）实现。在示例程序中，由AbstractClass类扮演次角色。

####ConCreteClass具体类

该角色负责具体实现AbstractClass角色中定义的抽象方法，这里实现的方法将在AbstractClass
角色的模板方法中被调用。在示例程序中由CharDisplay和StringDisplay类扮演次角色。


####要点

可以是使逻辑处理通用化

父类与子类之间协作

父类与子类的一致性
在示例程序中，不论是CharDisplay和StringDisplay的实例，都是先保存在AbstractClass
类型的变量中，然后再调用display方法的。
使用父类类型保存子类实例的优点是，及时没有用instanceof等指定子类的种类，程序
也能正常工作。
LSP：里氏替换原则
