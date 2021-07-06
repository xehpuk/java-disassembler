package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LStore2 extends LStoreAbstract {
	protected LStore2() {
		super(2);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.LSTORE_2;
	}
}