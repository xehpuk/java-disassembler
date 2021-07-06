package de.xehpuk.disassembler.reader;

import de.xehpuk.disassembler.AccessFlags;
import de.xehpuk.disassembler.ClassFileHead;
import de.xehpuk.disassembler.constantpool.ConstantPool;
import java.io.DataInput;
import java.io.IOException;

/**
 *
 * @author xehpuk
 */
public class ClassFileHeadReader extends Reader<ClassFileHead> {
	public ClassFileHeadReader(final DataInput in) {
		super(in);
	}

	@Override
	public ClassFileHead read() throws IOException {
		final int minorVersion = readMinorVersion();
		final int majorVersion = readMajorVersion();
		final ConstantPool constantPool = readConstantPool();
		final AccessFlags accessFlags = readAccessFlags();
		return new ClassFileHead(minorVersion, majorVersion, constantPool, accessFlags);
	}

	private int readMinorVersion() throws IOException {
		final int minorVersion = readUnsignedShort();
		return minorVersion;
	}

	private int readMajorVersion() throws IOException {
		final int majorVersion = readUnsignedShort();
		return majorVersion;
	}

	private ConstantPool readConstantPool() throws IOException {
		final ConstantPool constantPool = new ConstantPoolReader(this).read();
		return constantPool;
	}

	private AccessFlags readAccessFlags() throws IOException {
		final int accessFlags = readUnsignedShort();
		return new AccessFlags(accessFlags, AccessFlags.Type.CLASS);
	}
}