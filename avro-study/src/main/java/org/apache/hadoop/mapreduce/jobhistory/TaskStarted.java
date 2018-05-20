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
public class TaskStarted extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 2530057736357863261L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"TaskStarted\",\"namespace\":\"org.apache.hadoop.mapreduce.jobhistory\",\"fields\":[{\"name\":\"taskid\",\"type\":\"string\"},{\"name\":\"taskType\",\"type\":\"string\"},{\"name\":\"startTime\",\"type\":\"long\"},{\"name\":\"splitLocations\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<TaskStarted> ENCODER =
      new BinaryMessageEncoder<TaskStarted>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<TaskStarted> DECODER =
      new BinaryMessageDecoder<TaskStarted>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<TaskStarted> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<TaskStarted> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<TaskStarted>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this TaskStarted to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a TaskStarted from a ByteBuffer. */
  public static TaskStarted fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence taskid;
  @Deprecated public java.lang.CharSequence taskType;
  @Deprecated public long startTime;
  @Deprecated public java.lang.CharSequence splitLocations;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public TaskStarted() {}

  /**
   * All-args constructor.
   * @param taskid The new value for taskid
   * @param taskType The new value for taskType
   * @param startTime The new value for startTime
   * @param splitLocations The new value for splitLocations
   */
  public TaskStarted(java.lang.CharSequence taskid, java.lang.CharSequence taskType, java.lang.Long startTime, java.lang.CharSequence splitLocations) {
    this.taskid = taskid;
    this.taskType = taskType;
    this.startTime = startTime;
    this.splitLocations = splitLocations;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return taskid;
    case 1: return taskType;
    case 2: return startTime;
    case 3: return splitLocations;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: taskid = (java.lang.CharSequence)value$; break;
    case 1: taskType = (java.lang.CharSequence)value$; break;
    case 2: startTime = (java.lang.Long)value$; break;
    case 3: splitLocations = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'taskid' field.
   * @return The value of the 'taskid' field.
   */
  public java.lang.CharSequence getTaskid() {
    return taskid;
  }

  /**
   * Sets the value of the 'taskid' field.
   * @param value the value to set.
   */
  public void setTaskid(java.lang.CharSequence value) {
    this.taskid = value;
  }

  /**
   * Gets the value of the 'taskType' field.
   * @return The value of the 'taskType' field.
   */
  public java.lang.CharSequence getTaskType() {
    return taskType;
  }

  /**
   * Sets the value of the 'taskType' field.
   * @param value the value to set.
   */
  public void setTaskType(java.lang.CharSequence value) {
    this.taskType = value;
  }

  /**
   * Gets the value of the 'startTime' field.
   * @return The value of the 'startTime' field.
   */
  public java.lang.Long getStartTime() {
    return startTime;
  }

  /**
   * Sets the value of the 'startTime' field.
   * @param value the value to set.
   */
  public void setStartTime(java.lang.Long value) {
    this.startTime = value;
  }

  /**
   * Gets the value of the 'splitLocations' field.
   * @return The value of the 'splitLocations' field.
   */
  public java.lang.CharSequence getSplitLocations() {
    return splitLocations;
  }

  /**
   * Sets the value of the 'splitLocations' field.
   * @param value the value to set.
   */
  public void setSplitLocations(java.lang.CharSequence value) {
    this.splitLocations = value;
  }

  /**
   * Creates a new TaskStarted RecordBuilder.
   * @return A new TaskStarted RecordBuilder
   */
  public static org.apache.hadoop.mapreduce.jobhistory.TaskStarted.Builder newBuilder() {
    return new org.apache.hadoop.mapreduce.jobhistory.TaskStarted.Builder();
  }

  /**
   * Creates a new TaskStarted RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new TaskStarted RecordBuilder
   */
  public static org.apache.hadoop.mapreduce.jobhistory.TaskStarted.Builder newBuilder(org.apache.hadoop.mapreduce.jobhistory.TaskStarted.Builder other) {
    return new org.apache.hadoop.mapreduce.jobhistory.TaskStarted.Builder(other);
  }

  /**
   * Creates a new TaskStarted RecordBuilder by copying an existing TaskStarted instance.
   * @param other The existing instance to copy.
   * @return A new TaskStarted RecordBuilder
   */
  public static org.apache.hadoop.mapreduce.jobhistory.TaskStarted.Builder newBuilder(org.apache.hadoop.mapreduce.jobhistory.TaskStarted other) {
    return new org.apache.hadoop.mapreduce.jobhistory.TaskStarted.Builder(other);
  }

  /**
   * RecordBuilder for TaskStarted instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<TaskStarted>
    implements org.apache.avro.data.RecordBuilder<TaskStarted> {

    private java.lang.CharSequence taskid;
    private java.lang.CharSequence taskType;
    private long startTime;
    private java.lang.CharSequence splitLocations;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(org.apache.hadoop.mapreduce.jobhistory.TaskStarted.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.taskid)) {
        this.taskid = data().deepCopy(fields()[0].schema(), other.taskid);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.taskType)) {
        this.taskType = data().deepCopy(fields()[1].schema(), other.taskType);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.startTime)) {
        this.startTime = data().deepCopy(fields()[2].schema(), other.startTime);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.splitLocations)) {
        this.splitLocations = data().deepCopy(fields()[3].schema(), other.splitLocations);
        fieldSetFlags()[3] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing TaskStarted instance
     * @param other The existing instance to copy.
     */
    private Builder(org.apache.hadoop.mapreduce.jobhistory.TaskStarted other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.taskid)) {
        this.taskid = data().deepCopy(fields()[0].schema(), other.taskid);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.taskType)) {
        this.taskType = data().deepCopy(fields()[1].schema(), other.taskType);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.startTime)) {
        this.startTime = data().deepCopy(fields()[2].schema(), other.startTime);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.splitLocations)) {
        this.splitLocations = data().deepCopy(fields()[3].schema(), other.splitLocations);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'taskid' field.
      * @return The value.
      */
    public java.lang.CharSequence getTaskid() {
      return taskid;
    }

    /**
      * Sets the value of the 'taskid' field.
      * @param value The value of 'taskid'.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.TaskStarted.Builder setTaskid(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.taskid = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'taskid' field has been set.
      * @return True if the 'taskid' field has been set, false otherwise.
      */
    public boolean hasTaskid() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'taskid' field.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.TaskStarted.Builder clearTaskid() {
      taskid = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'taskType' field.
      * @return The value.
      */
    public java.lang.CharSequence getTaskType() {
      return taskType;
    }

    /**
      * Sets the value of the 'taskType' field.
      * @param value The value of 'taskType'.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.TaskStarted.Builder setTaskType(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.taskType = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'taskType' field has been set.
      * @return True if the 'taskType' field has been set, false otherwise.
      */
    public boolean hasTaskType() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'taskType' field.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.TaskStarted.Builder clearTaskType() {
      taskType = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'startTime' field.
      * @return The value.
      */
    public java.lang.Long getStartTime() {
      return startTime;
    }

    /**
      * Sets the value of the 'startTime' field.
      * @param value The value of 'startTime'.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.TaskStarted.Builder setStartTime(long value) {
      validate(fields()[2], value);
      this.startTime = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'startTime' field has been set.
      * @return True if the 'startTime' field has been set, false otherwise.
      */
    public boolean hasStartTime() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'startTime' field.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.TaskStarted.Builder clearStartTime() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'splitLocations' field.
      * @return The value.
      */
    public java.lang.CharSequence getSplitLocations() {
      return splitLocations;
    }

    /**
      * Sets the value of the 'splitLocations' field.
      * @param value The value of 'splitLocations'.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.TaskStarted.Builder setSplitLocations(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.splitLocations = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'splitLocations' field has been set.
      * @return True if the 'splitLocations' field has been set, false otherwise.
      */
    public boolean hasSplitLocations() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'splitLocations' field.
      * @return This builder.
      */
    public org.apache.hadoop.mapreduce.jobhistory.TaskStarted.Builder clearSplitLocations() {
      splitLocations = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TaskStarted build() {
      try {
        TaskStarted record = new TaskStarted();
        record.taskid = fieldSetFlags()[0] ? this.taskid : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.taskType = fieldSetFlags()[1] ? this.taskType : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.startTime = fieldSetFlags()[2] ? this.startTime : (java.lang.Long) defaultValue(fields()[2]);
        record.splitLocations = fieldSetFlags()[3] ? this.splitLocations : (java.lang.CharSequence) defaultValue(fields()[3]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<TaskStarted>
    WRITER$ = (org.apache.avro.io.DatumWriter<TaskStarted>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<TaskStarted>
    READER$ = (org.apache.avro.io.DatumReader<TaskStarted>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}