package de.xehpuk.disassembler.constantpool.bytes;

import de.xehpuk.disassembler.attribute.BootstrapMethodsTableEntry;
import de.xehpuk.disassembler.constantpool.ConstantPool;
import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.constantpool.model.ConstantInvokeDynamic;
import de.xehpuk.disassembler.constantpool.model.ConstantNameAndType;

/**
 *
 * @author xehpuk
 */
public class ConstantInvokeDynamicBytes implements ConstantPoolEntryRaw {
	private final int bootstrapMethodAttrIndex;
	private final int nameAndTypeIndex;

	public ConstantInvokeDynamicBytes(final int bootstrapMethodAttrIndex, final int nameAndTypeIndex) {
		this.bootstrapMethodAttrIndex = bootstrapMethodAttrIndex;
		this.nameAndTypeIndex = nameAndTypeIndex;
	}

	public int getBootstrapMethodAttrIndex() {
		return bootstrapMethodAttrIndex;
	}

	public int getNameAndTypeIndex() {
		return nameAndTypeIndex;
	}

	@Override
	public String toString() {
		return "ConstantInvokeDynamicInfo{" + "bootstrapMethodAttrIndex=" + bootstrapMethodAttrIndex + ", nameAndTypeIndex=" + nameAndTypeIndex + '}';
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.INVOKE_DYNAMIC;
	}

	@Override
	public ConstantInvokeDynamic convert(final int index, final ConstantPool pool) {
		final ConstantNameAndType nameAndType = pool.get(nameAndTypeIndex, ConstantNameAndType.class);
		final BootstrapMethodsTableEntry bootstrapMethods = pool.getBootstrapMethods(index);
		final ConstantInvokeDynamic result = new ConstantInvokeDynamic(bootstrapMethods, nameAndType);
		return result;
	}

	@Override
	public void dump(final int indent) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}