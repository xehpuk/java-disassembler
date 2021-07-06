package de.xehpuk.disassembler;

import de.xehpuk.disassembler.constantpool.ConstantPool;

/**
 *
 * @author xehpuk
 */
public class ClassFileHead {
	private final int minorVersion;
	private final int majorVersion;
	private final ConstantPool constantPool;
	private final AccessFlags accessFlags;

	public ClassFileHead(final int minorVersion, final int majorVersion, final ConstantPool constantPool, final AccessFlags accessFlags) {
		this.minorVersion = minorVersion;
		this.majorVersion = majorVersion;
		this.constantPool = constantPool;
		this.accessFlags = accessFlags;
	}

	public int getMinorVersion() {
		return minorVersion;
	}

	public int getMajorVersion() {
		return majorVersion;
	}

	public ConstantPool getConstantPool() {
		return constantPool;
	}

	public AccessFlags getAccessFlags() {
		return accessFlags;
	}
}