package de.xehpuk.disassembler.reader;

import de.xehpuk.disassembler.AccessFlags;
import de.xehpuk.disassembler.attribute.AnnotationTableEntry;
import de.xehpuk.disassembler.attribute.AnnotationValue;
import de.xehpuk.disassembler.attribute.ArrayValue;
import de.xehpuk.disassembler.attribute.Attribute;
import de.xehpuk.disassembler.attribute.AttributeAnnotationDefault;
import de.xehpuk.disassembler.attribute.AttributeBootstrapMethods;
import de.xehpuk.disassembler.attribute.AttributeCode;
import de.xehpuk.disassembler.attribute.AttributeConstantValue;
import de.xehpuk.disassembler.attribute.AttributeDeprecated;
import de.xehpuk.disassembler.attribute.AttributeEnclosingMethod;
import de.xehpuk.disassembler.attribute.AttributeExceptions;
import de.xehpuk.disassembler.attribute.AttributeInnerClasses;
import de.xehpuk.disassembler.attribute.AttributeLineNumberTable;
import de.xehpuk.disassembler.attribute.AttributeLocalVariableTable;
import de.xehpuk.disassembler.attribute.AttributeLocalVariableTypeTable;
import de.xehpuk.disassembler.attribute.AttributeRuntimeInvisibleAnnotations;
import de.xehpuk.disassembler.attribute.AttributeRuntimeInvisibleParameterAnnotations;
import de.xehpuk.disassembler.attribute.AttributeRuntimeVisibleAnnotations;
import de.xehpuk.disassembler.attribute.AttributeRuntimeVisibleParameterAnnotations;
import de.xehpuk.disassembler.attribute.AttributeSignature;
import de.xehpuk.disassembler.attribute.AttributeSourceFile;
import de.xehpuk.disassembler.attribute.AttributeSynthetic;
import de.xehpuk.disassembler.attribute.BootstrapMethodsTableEntry;
import de.xehpuk.disassembler.attribute.ClassInfo;
import de.xehpuk.disassembler.attribute.Classes;
import de.xehpuk.disassembler.attribute.ElementValue;
import de.xehpuk.disassembler.attribute.ElementValuePair;
import de.xehpuk.disassembler.attribute.EnumConstValue;
import de.xehpuk.disassembler.attribute.ExceptionTableEntry;
import de.xehpuk.disassembler.attribute.LineNumberTableEntry;
import de.xehpuk.disassembler.attribute.LocalVariableTableEntry;
import de.xehpuk.disassembler.attribute.LocalVariableTypeTableEntry;
import de.xehpuk.disassembler.attribute.ParameterAnnotationTableEntry;
import de.xehpuk.disassembler.attribute.RecognizedAttributeName;
import de.xehpuk.disassembler.attribute.UnrecognizedAttribute;
import de.xehpuk.disassembler.attribute.UnrecognizedAttributeName;
import de.xehpuk.disassembler.codes.Instruction;
import de.xehpuk.disassembler.codes.OpCode;
import de.xehpuk.disassembler.constantpool.ConstantBootstrapArgumentType;
import de.xehpuk.disassembler.constantpool.ConstantPool;
import de.xehpuk.disassembler.constantpool.ConstantValueAttributeType;
import de.xehpuk.disassembler.constantpool.model.ConstantClass;
import de.xehpuk.disassembler.constantpool.model.ConstantDouble;
import de.xehpuk.disassembler.constantpool.model.ConstantFloat;
import de.xehpuk.disassembler.constantpool.model.ConstantInteger;
import de.xehpuk.disassembler.constantpool.model.ConstantLong;
import de.xehpuk.disassembler.constantpool.model.ConstantMethodHandle;
import de.xehpuk.disassembler.constantpool.model.ConstantNameAndType;
import de.xehpuk.disassembler.constantpool.model.ConstantUtf8;
import de.xehpuk.disassembler.constants.TypeCharacter;
import de.xehpuk.disassembler.exceptions.IllegalAttributeLengthException;
import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xehpuk
 */
public class AttributesReader extends ReaderNeedingConstantPool<Attribute[]> {
	public AttributesReader(final DataInput in, final ConstantPool constantPool) {
		super(in, constantPool);
	}

	public AttributesReader(final ReaderNeedingConstantPool<?> reader) {
		super(reader);
	}

	@Override
	public Attribute[] read() throws IOException {
		final int attributesCount = readUnsignedShort();
		final Attribute[] attributes = new Attribute[attributesCount];
		for (int i = 0; i < attributesCount; i++) {
			attributes[i] = readAttribute();
		}
		return attributes;
	}

	private Attribute readAttribute() throws IOException {
		final int attributeNameIndex = readUnsignedShort();
		return readAttributeWithNameIndex(attributeNameIndex);
	}

	private Attribute readAttributeWithNameIndex(final int attributeNameIndex) throws IOException {
		final ConstantUtf8 attributeNameUtf8 = get(attributeNameIndex, ConstantUtf8.class);
		return readAttributeWithConstantUtf8(attributeNameUtf8);
	}

	private Attribute readAttributeWithConstantUtf8(final ConstantUtf8 attributeNameUtf8) throws IOException {
		final String attributeName = attributeNameUtf8.getString();
		return readAttributeWithName(attributeName);
	}

	private Attribute readAttributeWithName(final String attributeName) throws IOException {
		return RecognizedAttributeName.from(attributeName).read(this);
	}

	public AttributeConstantValue readConstantValue() throws IOException {
		final long attributeLength = readUnsignedInt();
		if (attributeLength != AttributeConstantValue.LENGTH) {
			throw new IllegalAttributeLengthException(attributeLength);
		}
		final int constantValueIndex = readUnsignedShort();
		final ConstantValueAttributeType constantValue = get(constantValueIndex, ConstantValueAttributeType.class);
		return new AttributeConstantValue(constantValue);
	}

	public AttributeCode readCode() throws IOException {
		final long attributeLength = readUnsignedInt();
		final int maxStack = readUnsignedShort();
		final int maxLocals = readUnsignedShort();
		final int codeLength = readInt();
		final List<Instruction> code = new ArrayList<>();
		for (int i = 0; i < codeLength; i++) {
			final OpCode op = OpCode.from(readByte());
			final Instruction instruction = op.read(this);
			code.add(instruction);
			i += op.getNumberOfArguments();
		}
		final ExceptionTableEntry[] exceptionTable = readExceptionTable();
		final Attribute[] attributes = new AttributesReader(this).read();
		return new AttributeCode(maxStack, maxLocals, code, exceptionTable, attributes);
	}

	private ExceptionTableEntry[] readExceptionTable() throws IOException {
		final int exceptionTableLength = readUnsignedShort();
		final ExceptionTableEntry[] exceptionTable = new ExceptionTableEntry[exceptionTableLength];
		for (int i = 0; i < exceptionTableLength; i++) {
			exceptionTable[i] = readExceptionTableEntry();
		}
		return exceptionTable;
	}

	private ExceptionTableEntry readExceptionTableEntry() throws IOException {
		final int startPc = readUnsignedShort();
		final int endPc = readUnsignedShort();
		final int handlerPc = readUnsignedShort();
		final int catchTypeIndex = readUnsignedShort();
		final ConstantClass catchType = get(catchTypeIndex, ConstantClass.class, catchTypeIndex == 0);
		return new ExceptionTableEntry(startPc, endPc, handlerPc, catchType);
	}

//	public AttributeStackMapTable readStackMapTable() throws IOException {
//      final long attributeLength = readUnsignedInt();
//	}
	public AttributeExceptions readExceptions() throws IOException {
		final long attributeLength = readUnsignedInt();
		final int numberOfExceptions = readUnsignedShort();
		final int[] classIndices = new int[numberOfExceptions];
		for (int i = 0; i < numberOfExceptions; i++) {
			classIndices[i] = readUnsignedShort();
		}
		final ConstantClass[] classes = new ConstantClass[numberOfExceptions];
		for (int i = 0; i < numberOfExceptions; i++) {
			classes[i] = get(classIndices[i], ConstantClass.class);
		}
		return new AttributeExceptions(classes);
	}

	public AttributeInnerClasses readInnerClasses() throws IOException {
		final long attributeLength = readUnsignedInt();
		final int numberOfClasses = readUnsignedShort();
		final Classes[] classes = new Classes[numberOfClasses];
		for (int i = 0; i < numberOfClasses; i++) {
			final int innerClassInfoIndex = readUnsignedShort();
			final ConstantClass innerClassInfo = get(innerClassInfoIndex, ConstantClass.class);
			final int outerClassInfoIndex = readUnsignedShort();
			// TODO outerClassInfoIndex may be zero
			final ConstantClass outerClassInfo = get(outerClassInfoIndex, ConstantClass.class, outerClassInfoIndex == 0);
			final int innerNameIndex = readUnsignedShort();
			// TODO innerNameIndex may be zero
			final ConstantUtf8 innerName = get(innerNameIndex, ConstantUtf8.class, innerNameIndex == 0);
			final int innerClassAccessFlags = readUnsignedShort();
			// TODO validate innerClassAccessFlags
			classes[i] = new Classes(innerClassInfo, outerClassInfo, innerName, new AccessFlags(innerClassAccessFlags, AccessFlags.Type.NESTED_CLASS));
		}
		return new AttributeInnerClasses(classes);
	}

	public AttributeEnclosingMethod readEnclosingMethod() throws IOException {
		final long attributeLength = readUnsignedInt();
		if (attributeLength != AttributeEnclosingMethod.LENGTH) {
			throw new IllegalAttributeLengthException(attributeLength);
		}
		final int classIndex = readUnsignedShort();
		final ConstantClass clazz = get(classIndex, ConstantClass.class);
		final int methodIndex = readUnsignedShort();
		// TODO methodIndex may be zero
		final ConstantNameAndType method = get(methodIndex, ConstantNameAndType.class, methodIndex == 0);
		return new AttributeEnclosingMethod(clazz, method);
	}

	public AttributeSynthetic readSynthetic() throws IOException {
		final long attributeLength = readUnsignedInt();
		if (attributeLength != AttributeSynthetic.LENGTH) {
			throw new IllegalAttributeLengthException(attributeLength);
		}
		return new AttributeSynthetic();
	}

	public AttributeSignature readSignature() throws IOException {
		final long attributeLength = readUnsignedInt();
		if (attributeLength != AttributeSignature.LENGTH) {
			throw new IllegalAttributeLengthException(attributeLength);
		}
		final int signatureIndex = readUnsignedShort();
		final ConstantUtf8 signature = get(signatureIndex, ConstantUtf8.class);
		return new AttributeSignature(signature);
	}

	public AttributeSourceFile readSourceFile() throws IOException {
		final long attributeLength = readUnsignedInt();
		if (attributeLength != AttributeSourceFile.LENGTH) {
			throw new IllegalAttributeLengthException(attributeLength);
		}
		final int sourceFileIndex = readUnsignedShort();
		final ConstantUtf8 sourceFile = get(sourceFileIndex, ConstantUtf8.class);
		return new AttributeSourceFile(sourceFile);
	}

//	public AttributeSourceDebugExtension readSourceDebugExtension() throws IOException {
//      final long attributeLength = readUnsignedInt();
//      final byte[] debugExtension = new byte[attributeLength];
//      for (int i = 0; i < attributeLength; i++)
//          debugExtension[i] = readByte();
//      return new AttributeSourceDebugExtensionBytes(debugExtension);
//	}
	public AttributeLineNumberTable readLineNumberTable() throws IOException {
		final long attributeLength = readUnsignedInt();
		final int lineNumberTableLength = readUnsignedShort();
		final LineNumberTableEntry[] lineNumberTable = new LineNumberTableEntry[lineNumberTableLength];
		for (int i = 0; i < lineNumberTableLength; i++) {
			final int startPc = readUnsignedShort();
			final int lineNumber = readUnsignedShort();
			lineNumberTable[i] = new LineNumberTableEntry(startPc, lineNumber);
		}
		return new AttributeLineNumberTable(lineNumberTable);
	}

	public AttributeLocalVariableTable readLocalVariableTable() throws IOException {
		final long attributeLength = readUnsignedInt();
		final int localVariableTableLength = readUnsignedShort();
		final LocalVariableTableEntry[] localVariableTable = new LocalVariableTableEntry[localVariableTableLength];
		for (int i = 0; i < localVariableTableLength; i++) {
			final int startPc = readUnsignedShort();
			final int length = readUnsignedShort();
			final int nameIndex = readUnsignedShort();
			final ConstantUtf8 name = get(nameIndex, ConstantUtf8.class);
			final int descriptorIndex = readUnsignedShort();
			final ConstantUtf8 descriptor = get(descriptorIndex, ConstantUtf8.class);
			final int index = readUnsignedShort();
			localVariableTable[i] = new LocalVariableTableEntry(startPc, length, name, descriptor, index);
		}
		return new AttributeLocalVariableTable(localVariableTable);
	}

	public AttributeLocalVariableTypeTable readLocalVariableTypeTable() throws IOException {
		final long attributeLength = readUnsignedInt();
		final int localVariableTableLength = readUnsignedShort();
		final LocalVariableTypeTableEntry[] localVariableTable = new LocalVariableTypeTableEntry[localVariableTableLength];
		for (int i = 0; i < localVariableTableLength; i++) {
			final int startPc = readUnsignedShort();
			final int length = readUnsignedShort();
			final int nameIndex = readUnsignedShort();
			final ConstantUtf8 name = get(nameIndex, ConstantUtf8.class);
			final int signatureIndex = readUnsignedShort();
			final ConstantUtf8 signature = get(signatureIndex, ConstantUtf8.class);
			final int index = readUnsignedShort();
			localVariableTable[i] = new LocalVariableTypeTableEntry(startPc, length, name, signature, index);
		}
		return new AttributeLocalVariableTypeTable(localVariableTable);
	}

	public AttributeDeprecated readDeprecated() throws IOException {
		final long attributeLength = readUnsignedInt();
		if (attributeLength != AttributeDeprecated.LENGTH) {
			throw new IllegalAttributeLengthException(attributeLength);
		}
		return new AttributeDeprecated();
	}

	public AttributeRuntimeVisibleAnnotations readRuntimeVisibleAnnotations() throws IOException {
		final long attributeLength = readUnsignedInt();
		final AnnotationTableEntry[] annotationTable = readAnnotationTable();
		return new AttributeRuntimeVisibleAnnotations(annotationTable);
	}

	private AnnotationTableEntry[] readAnnotationTable() throws IOException {
		final int numberOfAnnotations = readUnsignedShort();
		final AnnotationTableEntry[] annotationTable = new AnnotationTableEntry[numberOfAnnotations];
		for (int i = 0; i < numberOfAnnotations; i++) {
			annotationTable[i] = readAnnotationTableValue();
		}
		return annotationTable;
	}

	private AnnotationTableEntry readAnnotationTableValue() throws IOException {
		final int typeIndex = readUnsignedShort();
		final ConstantUtf8 type = get(typeIndex, ConstantUtf8.class);
		final ElementValuePair[] elementValuePairs = readElementValuePairs();
		return new AnnotationTableEntry(type, elementValuePairs);
	}

	private ElementValuePair[] readElementValuePairs() throws IOException {
		final int numberOfElementValueParis = readUnsignedShort();
		final ElementValuePair[] elementValuePairs = new ElementValuePair[numberOfElementValueParis];
		for (int i = 0; i < numberOfElementValueParis; i++) {
			final int elementNameIndex = readUnsignedShort();
			final ConstantUtf8 elementName = get(elementNameIndex, ConstantUtf8.class);
			final ElementValue value = readElementValue();
			elementValuePairs[i] = new ElementValuePair(elementName, value);
		}
		return elementValuePairs;
	}

	private ElementValue readElementValue() throws IOException {
		final char tag = (char) readUnsignedByte();
		return readElementValueWithTag(tag);
	}

	private ElementValue readElementValueWithTag(final char tag) throws IOException {
		return TypeCharacter.from(tag).read(this);
	}

	public ConstantInteger readConstantInteger() throws IOException {
		final int constValueIndex = readUnsignedShort();
		return get(constValueIndex, ConstantInteger.class);
	}

	public ConstantDouble readConstantDouble() throws IOException {
		final int constValueIndex = readUnsignedShort();
		return get(constValueIndex, ConstantDouble.class);
	}

	public ConstantFloat readConstantFloat() throws IOException {
		final int constValueIndex = readUnsignedShort();
		return get(constValueIndex, ConstantFloat.class);
	}

	public ConstantLong readConstantLong() throws IOException {
		final int constValueIndex = readUnsignedShort();
		return get(constValueIndex, ConstantLong.class);
	}

	public ConstantUtf8 readConstantUtf8() throws IOException {
		final int constValueIndex = readUnsignedShort();
		return get(constValueIndex, ConstantUtf8.class);
	}

	public EnumConstValue readEnumConstValue() throws IOException {
		final int typeNameIndex = readUnsignedShort();
		final ConstantUtf8 typeName = get(typeNameIndex, ConstantUtf8.class);
		final int constNameIndex = readUnsignedShort();
		final ConstantUtf8 constName = get(constNameIndex, ConstantUtf8.class);
		return new EnumConstValue(typeName, constName);
	}

	public ClassInfo readClassInfo() throws IOException {
		final int classInfoIndex = readUnsignedShort();
		final ConstantUtf8 classInfo = get(classInfoIndex, ConstantUtf8.class);
		return new ClassInfo(classInfo);
	}

	public AnnotationValue readAnnotationValue() throws IOException {
		final AnnotationTableEntry annotationValue = readAnnotationTableValue();
		return new AnnotationValue(annotationValue);
	}

	public ArrayValue readArrayValue() throws IOException {
		final ElementValue[] values = readElementValues();
		return new ArrayValue(values);
	}

	private ElementValue[] readElementValues() throws IOException {
		final int numberOfValues = readUnsignedShort();
		final ElementValue[] values = new ElementValue[numberOfValues];
		for (int i = 0; i < numberOfValues; i++) {
			values[i] = readElementValue();
		}
		return values;
	}

	public AttributeRuntimeInvisibleAnnotations readRuntimeInvisibleAnnotations() throws IOException {
		final long attributeLength = readUnsignedInt();
		final AnnotationTableEntry[] annotationTable = readAnnotationTable();
		return new AttributeRuntimeInvisibleAnnotations(annotationTable);
	}

	public AttributeRuntimeVisibleParameterAnnotations readRuntimeVisibleParameterAnnotations() throws IOException {
		final long attributeLength = readUnsignedInt();
		final ParameterAnnotationTableEntry[] parameterAnnotations = readParameterAnnotationTable();
		return new AttributeRuntimeVisibleParameterAnnotations(parameterAnnotations);
	}

	private ParameterAnnotationTableEntry[] readParameterAnnotationTable() throws IOException {
		final int numberOfParameters = readUnsignedByte();
		final ParameterAnnotationTableEntry[] parameterAnnotations = new ParameterAnnotationTableEntry[numberOfParameters];
		for (int i = 0; i < numberOfParameters; i++) {
			parameterAnnotations[i] = readParameterAnnotation();
		}
		return parameterAnnotations;
	}

	private ParameterAnnotationTableEntry readParameterAnnotation() throws IOException {
		final AnnotationTableEntry[] annotations = readAnnotationTable();
		return new ParameterAnnotationTableEntry(annotations);
	}

	public AttributeRuntimeInvisibleParameterAnnotations readRuntimeInvisibleParameterAnnotations() throws IOException {
		final long attributeLength = readUnsignedInt();
		final ParameterAnnotationTableEntry[] parameterAnnotations = readParameterAnnotationTable();
		return new AttributeRuntimeInvisibleParameterAnnotations(parameterAnnotations);
	}

	public AttributeAnnotationDefault readAnnotationDefault() throws IOException {
		final long attributeLength = readUnsignedInt();
		final ElementValue defaultValue = readElementValue();
		return new AttributeAnnotationDefault(defaultValue);
	}

	public AttributeBootstrapMethods readBootstrapMethods() throws IOException {
		final long attributeLength = readUnsignedInt();
		final BootstrapMethodsTableEntry[] bootstrapMethods = readBootstrapMethodsTable();
		return new AttributeBootstrapMethods(bootstrapMethods);
	}

	private BootstrapMethodsTableEntry[] readBootstrapMethodsTable() throws IOException {
		final int numberOfBootstrapMethods = readUnsignedShort();
		final BootstrapMethodsTableEntry[] bootstrapMethodsTable = new BootstrapMethodsTableEntry[numberOfBootstrapMethods];
		for (int i = 0; i < numberOfBootstrapMethods; i++) {
			bootstrapMethodsTable[i] = readBootstrapMethodsTableEntry();
		}
		constantPool.set(bootstrapMethodsTable);
		return bootstrapMethodsTable;
	}

	private BootstrapMethodsTableEntry readBootstrapMethodsTableEntry() throws IOException {
		final int bootstrapMethodRef = readUnsignedShort();
		final ConstantMethodHandle<?> bootstrapMethod = get(bootstrapMethodRef, ConstantMethodHandle.class);
		final int numberOfBootstrapArguments = readUnsignedShort();
		final ConstantBootstrapArgumentType[] bootstrapArguments = new ConstantBootstrapArgumentType[numberOfBootstrapArguments];
		for (int i = 0; i < numberOfBootstrapArguments; i++) {
			final int bootstrapArgumentIndex = readUnsignedShort();
			bootstrapArguments[i] = get(bootstrapArgumentIndex, ConstantBootstrapArgumentType.class);
		}
		return new BootstrapMethodsTableEntry(bootstrapMethod, bootstrapArguments);
	}

	public UnrecognizedAttribute readUnrecognized(final UnrecognizedAttributeName name) throws IOException {
		final long attributeLength = readUnsignedInt();
		skipFully(attributeLength);
		return new UnrecognizedAttribute(name);
	}
}