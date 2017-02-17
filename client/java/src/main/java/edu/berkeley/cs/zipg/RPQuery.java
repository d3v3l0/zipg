/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package edu.berkeley.cs.zipg;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-02-16")
public class RPQuery implements org.apache.thrift.TBase<RPQuery, RPQuery._Fields>, java.io.Serializable, Cloneable, Comparable<RPQuery> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("RPQuery");

  private static final org.apache.thrift.protocol.TField PATH_QUERIES_FIELD_DESC = new org.apache.thrift.protocol.TField("path_queries", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField RECURSE_FIELD_DESC = new org.apache.thrift.protocol.TField("recurse", org.apache.thrift.protocol.TType.BOOL, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new RPQueryStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new RPQueryTupleSchemeFactory();

  public java.util.List<java.util.List<java.lang.Long>> path_queries; // required
  public boolean recurse; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PATH_QUERIES((short)1, "path_queries"),
    RECURSE((short)2, "recurse");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // PATH_QUERIES
          return PATH_QUERIES;
        case 2: // RECURSE
          return RECURSE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __RECURSE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PATH_QUERIES, new org.apache.thrift.meta_data.FieldMetaData("path_queries", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)))));
    tmpMap.put(_Fields.RECURSE, new org.apache.thrift.meta_data.FieldMetaData("recurse", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(RPQuery.class, metaDataMap);
  }

  public RPQuery() {
  }

  public RPQuery(
    java.util.List<java.util.List<java.lang.Long>> path_queries,
    boolean recurse)
  {
    this();
    this.path_queries = path_queries;
    this.recurse = recurse;
    setRecurseIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RPQuery(RPQuery other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetPath_queries()) {
      java.util.List<java.util.List<java.lang.Long>> __this__path_queries = new java.util.ArrayList<java.util.List<java.lang.Long>>(other.path_queries.size());
      for (java.util.List<java.lang.Long> other_element : other.path_queries) {
        java.util.List<java.lang.Long> __this__path_queries_copy = new java.util.ArrayList<java.lang.Long>(other_element);
        __this__path_queries.add(__this__path_queries_copy);
      }
      this.path_queries = __this__path_queries;
    }
    this.recurse = other.recurse;
  }

  public RPQuery deepCopy() {
    return new RPQuery(this);
  }

  @Override
  public void clear() {
    this.path_queries = null;
    setRecurseIsSet(false);
    this.recurse = false;
  }

  public int getPath_queriesSize() {
    return (this.path_queries == null) ? 0 : this.path_queries.size();
  }

  public java.util.Iterator<java.util.List<java.lang.Long>> getPath_queriesIterator() {
    return (this.path_queries == null) ? null : this.path_queries.iterator();
  }

  public void addToPath_queries(java.util.List<java.lang.Long> elem) {
    if (this.path_queries == null) {
      this.path_queries = new java.util.ArrayList<java.util.List<java.lang.Long>>();
    }
    this.path_queries.add(elem);
  }

  public java.util.List<java.util.List<java.lang.Long>> getPath_queries() {
    return this.path_queries;
  }

  public RPQuery setPath_queries(java.util.List<java.util.List<java.lang.Long>> path_queries) {
    this.path_queries = path_queries;
    return this;
  }

  public void unsetPath_queries() {
    this.path_queries = null;
  }

  /** Returns true if field path_queries is set (has been assigned a value) and false otherwise */
  public boolean isSetPath_queries() {
    return this.path_queries != null;
  }

  public void setPath_queriesIsSet(boolean value) {
    if (!value) {
      this.path_queries = null;
    }
  }

  public boolean isRecurse() {
    return this.recurse;
  }

  public RPQuery setRecurse(boolean recurse) {
    this.recurse = recurse;
    setRecurseIsSet(true);
    return this;
  }

  public void unsetRecurse() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __RECURSE_ISSET_ID);
  }

  /** Returns true if field recurse is set (has been assigned a value) and false otherwise */
  public boolean isSetRecurse() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __RECURSE_ISSET_ID);
  }

  public void setRecurseIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __RECURSE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case PATH_QUERIES:
      if (value == null) {
        unsetPath_queries();
      } else {
        setPath_queries((java.util.List<java.util.List<java.lang.Long>>)value);
      }
      break;

    case RECURSE:
      if (value == null) {
        unsetRecurse();
      } else {
        setRecurse((java.lang.Boolean)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case PATH_QUERIES:
      return getPath_queries();

    case RECURSE:
      return isRecurse();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case PATH_QUERIES:
      return isSetPath_queries();
    case RECURSE:
      return isSetRecurse();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof RPQuery)
      return this.equals((RPQuery)that);
    return false;
  }

  public boolean equals(RPQuery that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_path_queries = true && this.isSetPath_queries();
    boolean that_present_path_queries = true && that.isSetPath_queries();
    if (this_present_path_queries || that_present_path_queries) {
      if (!(this_present_path_queries && that_present_path_queries))
        return false;
      if (!this.path_queries.equals(that.path_queries))
        return false;
    }

    boolean this_present_recurse = true;
    boolean that_present_recurse = true;
    if (this_present_recurse || that_present_recurse) {
      if (!(this_present_recurse && that_present_recurse))
        return false;
      if (this.recurse != that.recurse)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetPath_queries()) ? 131071 : 524287);
    if (isSetPath_queries())
      hashCode = hashCode * 8191 + path_queries.hashCode();

    hashCode = hashCode * 8191 + ((recurse) ? 131071 : 524287);

    return hashCode;
  }

  @Override
  public int compareTo(RPQuery other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetPath_queries()).compareTo(other.isSetPath_queries());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPath_queries()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.path_queries, other.path_queries);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetRecurse()).compareTo(other.isSetRecurse());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRecurse()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.recurse, other.recurse);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("RPQuery(");
    boolean first = true;

    sb.append("path_queries:");
    if (this.path_queries == null) {
      sb.append("null");
    } else {
      sb.append(this.path_queries);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("recurse:");
    sb.append(this.recurse);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class RPQueryStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public RPQueryStandardScheme getScheme() {
      return new RPQueryStandardScheme();
    }
  }

  private static class RPQueryStandardScheme extends org.apache.thrift.scheme.StandardScheme<RPQuery> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, RPQuery struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PATH_QUERIES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.path_queries = new java.util.ArrayList<java.util.List<java.lang.Long>>(_list0.size);
                java.util.List<java.lang.Long> _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  {
                    org.apache.thrift.protocol.TList _list3 = iprot.readListBegin();
                    _elem1 = new java.util.ArrayList<java.lang.Long>(_list3.size);
                    long _elem4;
                    for (int _i5 = 0; _i5 < _list3.size; ++_i5)
                    {
                      _elem4 = iprot.readI64();
                      _elem1.add(_elem4);
                    }
                    iprot.readListEnd();
                  }
                  struct.path_queries.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setPath_queriesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // RECURSE
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.recurse = iprot.readBool();
              struct.setRecurseIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, RPQuery struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.path_queries != null) {
        oprot.writeFieldBegin(PATH_QUERIES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.LIST, struct.path_queries.size()));
          for (java.util.List<java.lang.Long> _iter6 : struct.path_queries)
          {
            {
              oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I64, _iter6.size()));
              for (long _iter7 : _iter6)
              {
                oprot.writeI64(_iter7);
              }
              oprot.writeListEnd();
            }
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(RECURSE_FIELD_DESC);
      oprot.writeBool(struct.recurse);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class RPQueryTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public RPQueryTupleScheme getScheme() {
      return new RPQueryTupleScheme();
    }
  }

  private static class RPQueryTupleScheme extends org.apache.thrift.scheme.TupleScheme<RPQuery> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, RPQuery struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetPath_queries()) {
        optionals.set(0);
      }
      if (struct.isSetRecurse()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetPath_queries()) {
        {
          oprot.writeI32(struct.path_queries.size());
          for (java.util.List<java.lang.Long> _iter8 : struct.path_queries)
          {
            {
              oprot.writeI32(_iter8.size());
              for (long _iter9 : _iter8)
              {
                oprot.writeI64(_iter9);
              }
            }
          }
        }
      }
      if (struct.isSetRecurse()) {
        oprot.writeBool(struct.recurse);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, RPQuery struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list10 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.LIST, iprot.readI32());
          struct.path_queries = new java.util.ArrayList<java.util.List<java.lang.Long>>(_list10.size);
          java.util.List<java.lang.Long> _elem11;
          for (int _i12 = 0; _i12 < _list10.size; ++_i12)
          {
            {
              org.apache.thrift.protocol.TList _list13 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I64, iprot.readI32());
              _elem11 = new java.util.ArrayList<java.lang.Long>(_list13.size);
              long _elem14;
              for (int _i15 = 0; _i15 < _list13.size; ++_i15)
              {
                _elem14 = iprot.readI64();
                _elem11.add(_elem14);
              }
            }
            struct.path_queries.add(_elem11);
          }
        }
        struct.setPath_queriesIsSet(true);
      }
      if (incoming.get(1)) {
        struct.recurse = iprot.readBool();
        struct.setRecurseIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

