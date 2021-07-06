package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public interface ConstantInstruction extends Instruction {
	byte getConstant();
}