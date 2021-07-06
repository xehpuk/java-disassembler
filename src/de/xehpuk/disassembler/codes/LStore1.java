package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LStore1 extends LStoreAbstract {
	protected LStore1() {
		super(1);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.LSTORE_1;
	}
}