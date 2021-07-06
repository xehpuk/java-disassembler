package de.xehpuk.disassembler.codes;

public enum ImplicitConstant implements ConstantInstruction {
	ICONST_M1((byte) -1) {
		@Override
		public OpCode getOpCode() {
			return OpCode.ICONST_M1;
		}
	},
	ICONST_0((byte) 0) {
		@Override
		public OpCode getOpCode() {
			return OpCode.ICONST_0;
		}
	},
	ICONST_1((byte) 1) {
		@Override
		public OpCode getOpCode() {
			return OpCode.ICONST_1;
		}
	},
	ICONST_2((byte) 2) {
		@Override
		public OpCode getOpCode() {
			return OpCode.ICONST_2;
		}
	},
	ICONST_3((byte) 3) {
		@Override
		public OpCode getOpCode() {
			return OpCode.ICONST_3;
		}
	},
	ICONST_4((byte) 4) {
		@Override
		public OpCode getOpCode() {
			return OpCode.ICONST_4;
		}
	},
	ICONST_5((byte) 5) {
		@Override
		public OpCode getOpCode() {
			return OpCode.ICONST_5;
		}
	},
	LCONST_0((byte) 0) {
		@Override
		public OpCode getOpCode() {
			return OpCode.LCONST_0;
		}
	},
	LCONST_1((byte) 1) {
		@Override
		public OpCode getOpCode() {
			return OpCode.LCONST_1;
		}
	},
	FCONST_0((byte) 0) {
		@Override
		public OpCode getOpCode() {
			return OpCode.FCONST_0;
		}
	},
	FCONST_1((byte) 1) {
		@Override
		public OpCode getOpCode() {
			return OpCode.FCONST_1;
		}
	},
	FCONST_2((byte) 2) {
		@Override
		public OpCode getOpCode() {
			return OpCode.FCONST_2;
		}
	},
	DCONST_0((byte) 0) {
		@Override
		public OpCode getOpCode() {
			return OpCode.DCONST_0;
		}
	},
	DCONST_1((byte) 1) {
		@Override
		public OpCode getOpCode() {
			return OpCode.DCONST_1;
		}
	};
	private final byte constant;

	private ImplicitConstant(final byte constant) {
		this.constant = constant;
	}

	@Override
	public final byte getConstant() {
		return constant;
	}
}