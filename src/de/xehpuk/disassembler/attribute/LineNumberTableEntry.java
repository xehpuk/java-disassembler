package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.Dumpable;
import de.xehpuk.disassembler.util.Util;

public class LineNumberTableEntry implements Dumpable {
	private final int startPc;
	private final int lineNumber;

	public LineNumberTableEntry(final int startPc, final int lineNumber) {
		this.startPc = startPc;
		this.lineNumber = lineNumber;
	}

	public int getStartPc() {
		return startPc;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	@Override
	public String toString() {
		return "LineNumberTableEntry{" + startPc + ", " + lineNumber + '}';
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.println(startPc + ", " + lineNumber);
	}
}