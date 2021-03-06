package NUS.Duke.DTO;

public class EventDTO extends TaskDTO {

    private String eventTime;

    @Override
    public String getTaskType() {
        return "E";
    }

    public EventDTO(String taskName,String eventTime) {
        this.setTaskName(taskName);
        this.eventTime = eventTime;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    @Override
    public String toString() {
        return super.toString() +" (at: "+eventTime+" )";
    }

    @Override
    public String getTaskFullDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(getTaskType());
        sb.append("]");
        sb.append("[");
        int ascii = 0;
        if (!isDone()){
            ascii = 0x2717;
        }else {
            ascii = 0x2713;
        }

        String sign = Character.toString((char)ascii);
        sb.append(sign +"]");
        sb.append(getTaskName());
        sb.append("(at: ");
        sb.append(eventTime);
        sb.append(" )");
        return sb.toString();
    }

    @Override
    public String getPrintFileString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getTaskType());
        sb.append(" | ");

        if (!isDone()){
            sb.append("0");
        }else {
            sb.append("1");
        }
        sb.append(" | ");
        sb.append(getTaskName());
        sb.append(" | ");
        sb.append(eventTime);
        sb.append("\n");
        return sb.toString();
    }
}
