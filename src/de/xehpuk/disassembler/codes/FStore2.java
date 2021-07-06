package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class FStore2 extends FStoreAbstract {
	protected FStore2() {
		super(2);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.FSTORE_2;
	}
}