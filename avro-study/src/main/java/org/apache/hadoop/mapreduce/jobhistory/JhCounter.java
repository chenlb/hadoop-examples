/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package org.apache.hadoop.mapreduce.jobhistory;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class JhCounter extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 140896298550477629L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"JhCounter\",\"namespace\":\"org.apache.hadoop.mapreduce.jobhistory\",\"fields\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"displayName\",\"type\":\"string\"},{\"name\":\"value\",\"type\":\"long\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<JhCounter> ENCODER =
      new BinaryMessageEncoder<JhCounter>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<JhCounter> DECODER =
      new BinaryMessageDecoder<JhCounter>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<JhCounter> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<JhCounter> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<JhCounter>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this JhCounter to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a JhCounter from a ByteBuffer. */
  public static JhCounter fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence name;
  @Deprecated public java.lang.CharSequence displayName;
  @Deprecated public long value;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public JhCounter() {}

  /**
   * All-args constructor.
   * @param name The new value for name
   * @param displayName The new value for displayName
   * @param value The new value for value
   */
  public JhCounter(java.lang.CharSequence name, java.lang.CharSequence displayName, java.lang.Long value) {
    this.name = name;
    this.displayName = displayName;
    this.value = value;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return name;
    case 1: return displayName;
    case 2: return value;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: name = (java.lang.CharSequence)value$; break;
    case 1: displayName = (java.lang.CharSequence)value$; break;
    case 2: value = (java.lang.Long)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'displayName' field.
   * @return The value of the 'displayName' field.
   */
  public java.lang.CharSequence getDisplayName() {
    return displayName;
  }

  /**
   * Sets the value of the 'displayName' field.
   * @param value the value to set.
   */
  public void setDisplayName(java.lang.CharSequence value) {
    this.displayName = value;
  }

  /**
   * Gets the value of the 'value' field.
   * @return The value of the 'value' field.
   */
  public java.lang.Long getValue() {
    return value;
  }

  /**
   * Sets the value of the 'value' field.
   * @param value the value to set.
   */
  public void setValue(java.lang.Long value) {
    this.value = value;
  }

  /**
   * Creates a new JhCounter RecordBuilder.
   * @return A new JhCounter RecordBuilder
   */
  public static org.apache.hadoop.mapreduce.jobhistory.JhCounter.Builder newBuilder() {
    return new org.apache.hadoop.mapreduce.jobhistory.JhCounter.Builder();
  }

  /**
   * Creates a new JhCounter RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new JhCounter RecordBuilder
   */
  public static org.apache.hadoop.mapreduce.jobhistory.JhCounter.Builder newBuilder(org.apache.hadoop.mapreduce.jobhistory.JhCounter.Builder other) {
    return new org.apache.hadoop.mapreduce.jobhistory.JhCounter.Builder(other);
  }

  /**
   * Creates a new JhCounter RecordBuilder by copying an existing JhCounter instance.
   * @param other The existing instance to copy.
   * @return A new JhCounter RecordBuilder
   */
  public static org.apache.hadoop.mapreduce.jobhistory.JhCounter.Builder newBuilder(org.apache.hadoop.mapreduce.jobhistory.JhCounter other) {
    return new org.apache.hadoop.mapreduce.jobhistory.JhCounter.Builder(other);
  }

  /**
   * RecordBuilder for JhCounter instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<JhCounter>
    implements org.apache.avro.data.RecordBuilder<JhCounter> {

    private java.lang.CharSequence name;
    private java.lang.CharSequence displayName;
    private long value;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(org.apache.hadoop.mapreduce.jobhistory.JhCounter.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.displayName)) {
        this.displayName = data().deepCopy(fields()[1].schema(), other.displayName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.value)) {
        this.value = data().deepCopy(fields()[2].schema(), other.value);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing JhCounter instance
     * @param other The existing instance to copy.
     */
    private Builder(org.apache.hadoop.mapreduce.jobhistory.JhCounter other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.displayName)) {
        this.displayName = data().deepCopy(fields()[1].schema(), other.displayName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.value)) {
        this.value = data().deepCopy(fields()[2].schema(), other.value);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }

    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JhCounter.Builder setName(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.name = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JhCounter.Builder clearName() {
      name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'displayName' field.
      * @return The value.
      */
    public java.lang.CharSequence getDisplayName() {
      return displayName;
    }

    /**
      * Sets the value of the 'displayName' field.
      * @param value The value of 'displayName'.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JhCounter.Builder setDisplayName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.displayName = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'displayName' field has been set.
      * @return True if the 'displayName' field has been set, false otherwise.
      */
    public boolean hasDisplayName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'displayName' field.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JhCounter.Builder clearDisplayName() {
      displayName = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'value' field.
      * @return The value.
      */
    public java.lang.Long getValue() {
      return value;
    }

    /**
      * Sets the value of the 'value' field.
      * @param value The value of 'value'.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JhCounter.Builder setValue(long value) {
      validate(fields()[2], value);
      this.value = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'value' field has been set.
      * @return True if the 'value' field has been set, false otherwise.
      */
    public boolean hasValue() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'value' field.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.JhCounter.Builder clearValue() {
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JhCounter build() {
      try {
        JhCounter record = new JhCounter();
        record.name = fieldSetFlags()[0] ? this.name : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.displayName = fieldSetFlags()[1] ? this.displayName : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.value = fieldSetFlags()[2] ? this.value : (java.lang.Long) defaultValue(fields()[2]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<JhCounter>
    WRITER$ = (org.apache.avro.io.DatumWriter<JhCounter>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<JhCounter>
    READER$ = (org.apache.avro.io.DatumReader<JhCounter>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}