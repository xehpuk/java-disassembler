package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.Dumpable;
import de.xehpuk.disassembler.constantpool.model.ConstantClass;
import de.xehpuk.disassembler.util.Util;

public class ExceptionTableEntry implements Dumpable {
	private final int startPc;
	private final int endPc;
	private final int handlerPc;
	private final ConstantClass catchType;

	public ExceptionTableEntry(final int startPc, final int endPc, final int handlerPc, final ConstantClass catchType) {
		this.startPc = startPc;
		this.endPc = endPc;
		this.handlerPc = handlerPc;
		this.catchType = catchType;
	}

	public int getStartPc() {
		return startPc;
	}

	public int getEndPc() {
		return endPc;
	}

	public int getHandlerPc() {
		return handlerPc;
	}

	public ConstantClass getCatchType() {
		return catchType;
	}

	@Override
	public String toString() {
		return "ExceptionTableEntry{" + startPc + ", " + endPc + ", " + handlerPc + ", " + catchType + '}';
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.print(startPc + ", " + endPc + ", " + handlerPc + ", ");
		if (catchType != null) {
			catchType.dump(0);
		} else {
			System.out.print("any");
		}
		System.out.println();
	}
}