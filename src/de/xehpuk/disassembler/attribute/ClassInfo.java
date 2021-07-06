package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.constantpool.model.ConstantUtf8;
import de.xehpuk.disassembler.constants.TypeCharacter;

/**
 *
 * @author xehpuk
 */
public class ClassInfo implements ElementValue {
	private final ConstantUtf8 classInfo;

	public ClassInfo(final ConstantUtf8 classInfo) {
		this.classInfo = classInfo;
	}

	public ConstantUtf8 getClassInfo() {
		return classInfo;
	}

	@Override
	public TypeCharacter getType() {
		return TypeCharacter.CLASS;
	}
}