# Java Disassembler

While attending university for my bachelor's degree at around mid 2012 (according to [an on-topic question of mine on Stack Overflow](https://stackoverflow.com/questions/11660967/how-to-handle-the-unsigned-types-especially-u4-of-a-java-class-file-in-a-java)), I seemed to be mildly obsessed with Java's bytecode. I'm not exactly sure why, but trying to parse `class` files myself intrigued me. So I started this project and invested time in studying the respective [chapter 4 of the JVM specification](https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-4.html).

Running the project (the main class `de.xehpuk.disassembler.reader.ClassFileReader` disassembling itself) currently outputs this:

```
majorVersion = 51
minorVersion = 0
thisClass = de.xehpuk.disassembler.reader.ClassFileReader
superClass = de.xehpuk.disassembler.reader.Reader
interfaces: [none]
accessFlags: public 
constant_pool: 
  #001 = Methodref   de.xehpuk.disassembler.reader.Reader.<init>(java.io.DataInput)
  #002 = Class       de.xehpuk.disassembler.reader.Reader
  #003 = NameAndType <init>(java.io.DataInput)
  #004 = Utf8        de/xehpuk/disassembler/reader/Reader
  #005 = Utf8        <init>
  #006 = Utf8        (Ljava/io/DataInput;)V
  #007 = Methodref   de.xehpuk.disassembler.reader.ClassFileReader.readInt()
  #008 = Class       de.xehpuk.disassembler.reader.ClassFileReader
  #009 = NameAndType readInt()
  #010 = Utf8        de/xehpuk/disassembler/reader/ClassFileReader
  #011 = Utf8        readInt
  #012 = Utf8        ()I
  #013 = Class       de.xehpuk.disassembler.ClassFile
  #014 = Utf8        de/xehpuk/disassembler/ClassFile
  #015 = Integer     -889275714
  #016 = Class       de.xehpuk.disassembler.exceptions.IllegalMagicException
  #017 = Utf8        de/xehpuk/disassembler/exceptions/IllegalMagicException
  #018 = Methodref   de.xehpuk.disassembler.exceptions.IllegalMagicException.<init>(int)
  #019 = NameAndType <init>(int)
  #020 = Utf8        (I)V
  #021 = Methodref   de.xehpuk.disassembler.reader.ClassFileReader.readClassFileHead()
  #022 = NameAndType readClassFileHead()
  #023 = Utf8        readClassFileHead
  #024 = Utf8        ()Lde/xehpuk/disassembler/ClassFileHead;
  #025 = Methodref   de.xehpuk.disassembler.ClassFileHead.getConstantPool()
  #026 = Class       de.xehpuk.disassembler.ClassFileHead
  #027 = NameAndType getConstantPool()
  #028 = Utf8        de/xehpuk/disassembler/ClassFileHead
  #029 = Utf8        getConstantPool
  #030 = Utf8        ()Lde/xehpuk/disassembler/constantpool/ConstantPool;
  #031 = Methodref   de.xehpuk.disassembler.reader.ClassFileReader.readClassFileBody(de.xehpuk.disassembler.constantpool.ConstantPool)
  #032 = NameAndType readClassFileBody(de.xehpuk.disassembler.constantpool.ConstantPool)
  #033 = Utf8        readClassFileBody
  #034 = Utf8        (Lde/xehpuk/disassembler/constantpool/ConstantPool;)Lde/xehpuk/disassembler/ClassFileBody;
  #035 = Methodref   de.xehpuk.disassembler.ClassFile.<init>(de.xehpuk.disassembler.ClassFileHead, de.xehpuk.disassembler.ClassFileBody)
  #036 = NameAndType <init>(de.xehpuk.disassembler.ClassFileHead, de.xehpuk.disassembler.ClassFileBody)
  #037 = Utf8        (Lde/xehpuk/disassembler/ClassFileHead;Lde/xehpuk/disassembler/ClassFileBody;)V
  #038 = Class       de.xehpuk.disassembler.reader.ClassFileHeadReader
  #039 = Utf8        de/xehpuk/disassembler/reader/ClassFileHeadReader
  #040 = Methodref   de.xehpuk.disassembler.reader.ClassFileHeadReader.<init>(java.io.DataInput)
  #041 = Methodref   de.xehpuk.disassembler.reader.ClassFileHeadReader.read()
  #042 = NameAndType read()
  #043 = Utf8        read
  #044 = Class       de.xehpuk.disassembler.reader.ClassFileBodyReader
  #045 = Utf8        de/xehpuk/disassembler/reader/ClassFileBodyReader
  #046 = Methodref   de.xehpuk.disassembler.reader.ClassFileBodyReader.<init>(java.io.DataInput, de.xehpuk.disassembler.constantpool.ConstantPool)
  #047 = NameAndType <init>(java.io.DataInput, de.xehpuk.disassembler.constantpool.ConstantPool)
  #048 = Utf8        (Ljava/io/DataInput;Lde/xehpuk/disassembler/constantpool/ConstantPool;)V
  #049 = Methodref   de.xehpuk.disassembler.reader.ClassFileBodyReader.read()
  #050 = NameAndType read()
  #051 = Utf8        ()Lde/xehpuk/disassembler/ClassFileBody;
  #052 = Fieldref    System.java.io.PrintStream err
  #053 = Class       System
  #054 = NameAndType java.io.PrintStream err
  #055 = Utf8        java/lang/System
  #056 = Utf8        err
  #057 = Utf8        Ljava/io/PrintStream;
  #058 = String      "Usage: java -jar disassembler.jar <class-file>"
  #059 = Utf8        Usage: java -jar disassembler.jar <class-file>
  #060 = Methodref   java.io.PrintStream.println(String)
  #061 = Class       java.io.PrintStream
  #062 = NameAndType println(String)
  #063 = Utf8        java/io/PrintStream
  #064 = Utf8        println
  #065 = Utf8        (Ljava/lang/String;)V
  #066 = Methodref   System.exit(int)
  #067 = NameAndType exit(int)
  #068 = Utf8        exit
  #069 = Class       java.io.DataInputStream
  #070 = Utf8        java/io/DataInputStream
  #071 = Class       java.io.FileInputStream
  #072 = Utf8        java/io/FileInputStream
  #073 = Methodref   java.io.FileInputStream.<init>(String)
  #074 = NameAndType <init>(String)
  #075 = Methodref   java.io.DataInputStream.<init>(java.io.InputStream)
  #076 = NameAndType <init>(java.io.InputStream)
  #077 = Utf8        (Ljava/io/InputStream;)V
  #078 = Methodref   de.xehpuk.disassembler.reader.ClassFileReader.<init>(java.io.DataInput)
  #079 = Methodref   de.xehpuk.disassembler.reader.ClassFileReader.read()
  #080 = NameAndType read()
  #081 = Utf8        ()Lde/xehpuk/disassembler/ClassFile;
  #082 = Methodref   de.xehpuk.disassembler.ClassFile.dump(int)
  #083 = NameAndType dump(int)
  #084 = Utf8        dump
  #085 = Methodref   java.io.DataInputStream.close()
  #086 = NameAndType close()
  #087 = Utf8        close
  #088 = Utf8        ()V
  #089 = Class       Throwable
  #090 = Utf8        java/lang/Throwable
  #091 = Methodref   Throwable.addSuppressed(Throwable)
  #092 = NameAndType addSuppressed(Throwable)
  #093 = Utf8        addSuppressed
  #094 = Utf8        (Ljava/lang/Throwable;)V
  #095 = Utf8        Code
  #096 = Utf8        LineNumberTable
  #097 = Utf8        LocalVariableTable
  #098 = Utf8        this
  #099 = Utf8        Lde/xehpuk/disassembler/reader/ClassFileReader;
  #100 = Utf8        in
  #101 = Utf8        Ljava/io/DataInput;
  #102 = Utf8        magic
  #103 = Utf8        I
  #104 = Utf8        head
  #105 = Utf8        Lde/xehpuk/disassembler/ClassFileHead;
  #106 = Utf8        body
  #107 = Utf8        Lde/xehpuk/disassembler/ClassFileBody;
  #108 = Utf8        StackMapTable
  #109 = Utf8        Exceptions
  #110 = Class       java.io.IOException
  #111 = Utf8        java/io/IOException
  #112 = Utf8        constantPool
  #113 = Utf8        Lde/xehpuk/disassembler/constantpool/ConstantPool;
  #114 = Utf8        main
  #115 = Utf8        ([Ljava/lang/String;)V
  #116 = Utf8        reader
  #117 = Utf8        file
  #118 = Utf8        Lde/xehpuk/disassembler/ClassFile;
  #119 = Utf8        Ljava/io/DataInputStream;
  #120 = Utf8        args
  #121 = Utf8        [Ljava/lang/String;
  #122 = Class       [Ljava.lang.String;
  #123 = Utf8        ()Ljava/lang/Object;
  #124 = Utf8        Signature
  #125 = Utf8        Lde/xehpuk/disassembler/reader/Reader<Lde/xehpuk/disassembler/ClassFile;>;
  #126 = Utf8        SourceFile
  #127 = Utf8        ClassFileReader.java

fields: [none]

methods: 
  public void <init>(java.io.DataInput)
    Code:
      2, 2
      Instructions:
        ALOAD_0
        ALOAD_1
        INVOKESPECIAL
        RETURN
      LineNumberTable:
        0, 19
        5, 20
      LocalVariableTable:
        0, 6, this, Lde/xehpuk/disassembler/reader/ClassFileReader;, 0
        0, 6, in, Ljava/io/DataInput;, 1
  public de.xehpuk.disassembler.ClassFile read()
    Code:
      4, 4
      Instructions:
        ALOAD_0
        INVOKEVIRTUAL
        ISTORE_1
        ILOAD_1
        LDC
        IF_ICMPEQ
        NEW
        DUP
        ILOAD_1
        INVOKESPECIAL
        ATHROW
        ALOAD_0
        INVOKESPECIAL
        ASTORE_2
        ALOAD_0
        ALOAD_2
        INVOKEVIRTUAL
        INVOKESPECIAL
        ASTORE_3
        NEW
        DUP
        ALOAD_2
        ALOAD_3
        INVOKESPECIAL
        ARETURN
      LineNumberTable:
        0, 24
        5, 25
        11, 26
        20, 28
        25, 29
        34, 30
      LocalVariableTable:
        0, 44, this, Lde/xehpuk/disassembler/reader/ClassFileReader;, 0
        5, 39, magic, I, 1
        25, 19, head, Lde/xehpuk/disassembler/ClassFileHead;, 2
        34, 10, body, Lde/xehpuk/disassembler/ClassFileBody;, 3
      UnrecognizedAttribute=StackMapTable
    Exceptions:
      java.io.IOException
  private de.xehpuk.disassembler.ClassFileHead readClassFileHead()
    Code:
      3, 1
      Instructions:
        NEW
        DUP
        ALOAD_0
        INVOKESPECIAL
        INVOKEVIRTUAL
        ARETURN
      LineNumberTable:
        0, 34
      LocalVariableTable:
        0, 12, this, Lde/xehpuk/disassembler/reader/ClassFileReader;, 0
    Exceptions:
      java.io.IOException
  private de.xehpuk.disassembler.ClassFileBody readClassFileBody(de.xehpuk.disassembler.constantpool.ConstantPool)
    Code:
      4, 2
      Instructions:
        NEW
        DUP
        ALOAD_0
        ALOAD_1
        INVOKESPECIAL
        INVOKEVIRTUAL
        ARETURN
      LineNumberTable:
        0, 38
      LocalVariableTable:
        0, 13, this, Lde/xehpuk/disassembler/reader/ClassFileReader;, 0
        0, 13, constantPool, Lde/xehpuk/disassembler/constantpool/ConstantPool;, 1
    Exceptions:
      java.io.IOException
  public static varargs void main(String[])
    Code:
      6, 4
      Instructions:
        ALOAD_0
        ARRAYLENGTH
        IFNE
        GETSTATIC
        LDC
        INVOKEVIRTUAL
        ICONST_M1
        INVOKESTATIC
        NEW
        DUP
        NEW
        DUP
        ALOAD_0
        ICONST_0
        AALOAD
        INVOKESPECIAL
        INVOKESPECIAL
        ASTORE_1
        NEW
        DUP
        ALOAD_1
        INVOKESPECIAL
        ASTORE_2
        ALOAD_2
        INVOKEVIRTUAL
        ASTORE_3
        ALOAD_3
        ICONST_1
        INVOKEVIRTUAL
        ALOAD_1
        INVOKEVIRTUAL
        GOTO
        ASTORE_2
        ALOAD_1
        INVOKEVIRTUAL
        GOTO
        ASTORE_3
        ALOAD_2
        ALOAD_3
        INVOKEVIRTUAL
        ALOAD_2
        ATHROW
        RETURN
      ExceptionTable:
        35, 54, 61, Throwable
        62, 66, 69, Throwable
      LineNumberTable:
        0, 42
        5, 43
        13, 44
        17, 46
        35, 47
        44, 48
        49, 49
        54, 50
        61, 46
        77, 51
      LocalVariableTable:
        44, 10, reader, Lde/xehpuk/disassembler/reader/ClassFileReader;, 2
        49, 5, file, Lde/xehpuk/disassembler/ClassFile;, 3
        35, 42, in, Ljava/io/DataInputStream;, 1
        0, 78, args, [Ljava/lang/String;, 0
      UnrecognizedAttribute=StackMapTable
    Exceptions:
      java.io.IOException
  public bridge Object read()
    Code:
      1, 1
      Instructions:
        ALOAD_0
        INVOKEVIRTUAL
        ARETURN
      LineNumberTable:
        0, 17
      LocalVariableTable:
        0, 5, this, Lde/xehpuk/disassembler/reader/ClassFileReader;, 0
    Exceptions:
      java.io.IOException
attributes: 
  Signature=Lde/xehpuk/disassembler/reader/Reader<Lde/xehpuk/disassembler/ClassFile;>;
  SourceFile=ClassFileReader.java
```

I'm honestly quite amazed by how well this works, since I've never really learned the theoretical aspects of parsers and I couldn't remember the state of the project. An untrained eye may think that this is the output of the original `javap`.

With 11 `TODO`s (and certainly some hidden ones), it's definitely not finished. But who knows what the future holds…
