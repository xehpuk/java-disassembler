package de.xehpuk.disassembler;

/**
 *
 * @author xehpuk
 */
public interface Dumpable {
	static final int INDENT = 2;

	void dump(int indent);
}