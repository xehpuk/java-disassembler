package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.AccessFlags;
import de.xehpuk.disassembler.Dumpable;
import de.xehpuk.disassembler.constantpool.model.ConstantClass;
import de.xehpuk.disassembler.constantpool.model.ConstantUtf8;
import de.xehpuk.disassembler.util.Util;

public class Classes implements Dumpable {
	private final ConstantClass innerClassInfo;
	private final ConstantClass outerClassInfo;
	private final ConstantUtf8 innerName;
	private final AccessFlags innerClassAccessFlags;

	public Classes(final ConstantClass innerClassInfo, final ConstantClass outerClassInfo, final ConstantUtf8 innerName, final AccessFlags innerClassAccessFlags) {
		this.innerClassInfo = innerClassInfo;
		this.outerClassInfo = outerClassInfo;
		this.innerName = innerName;
		this.innerClassAccessFlags = innerClassAccessFlags;
	}

	public ConstantClass getInnerClassInfo() {
		return innerClassInfo;
	}

	public ConstantClass getOuterClassInfo() {
		return outerClassInfo;
	}

	public ConstantUtf8 getInnerName() {
		return innerName;
	}

	public AccessFlags getInnerClassAccessFlags() {
		return innerClassAccessFlags;
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.println("Classes {");
		System.out.print("inner_class = ");
		innerClassInfo.dump(indent + 1);
		System.out.println();
		System.out.print("outer_class = ");
		outerClassInfo.dump(indent + 1);
		System.out.println();
		System.out.print("inner_name = ");
		innerName.dump(indent + 1);
		System.out.println();
		Util.indent(indent);
		System.out.println("access_flags = " + innerClassAccessFlags);
		Util.indent(indent);
		System.out.println('}');
	}
}