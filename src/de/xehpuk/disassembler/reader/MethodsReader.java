package de.xehpuk.disassembler.reader;

import de.xehpuk.disassembler.AccessFlags;
import de.xehpuk.disassembler.Method;
import de.xehpuk.disassembler.attribute.Attribute;
import de.xehpuk.disassembler.constantpool.ConstantPool;
import de.xehpuk.disassembler.constantpool.model.ConstantUtf8;
import java.io.DataInput;
import java.io.IOException;

/**
 *
 * @author xehpuk
 */
public class MethodsReader extends ReaderNeedingConstantPool<Method[]> {
	public MethodsReader(final DataInput in, final ConstantPool constantPool) {
		super(in, constantPool);
	}

	public MethodsReader(final ReaderNeedingConstantPool<?> reader) {
		super(reader);
	}

	@Override
	public Method[] read() throws IOException {
		final int methodsCount = readUnsignedShort();
		final Method[] methods = new Method[methodsCount];
		for (int i = 0; i < methodsCount; i++) {
			methods[i] = readMethod();
		}
		return methods;
	}

	private Method readMethod() throws IOException {
		final int accessFlags = readUnsignedShort();
		final int nameIndex = readUnsignedShort();
		final ConstantUtf8 name = get(nameIndex, ConstantUtf8.class);
		final int descriptorIndex = readUnsignedShort();
		final ConstantUtf8 descriptor = get(descriptorIndex, ConstantUtf8.class);
		final Attribute[] attributes = new AttributesReader(this).read();
		return new Method(new AccessFlags(accessFlags, AccessFlags.Type.METHOD), name, descriptor, attributes);
	}
}