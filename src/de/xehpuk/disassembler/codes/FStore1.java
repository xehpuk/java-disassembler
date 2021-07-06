package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class FStore1 extends FStoreAbstract {
	protected FStore1() {
		super(1);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.FSTORE_1;
	}
}